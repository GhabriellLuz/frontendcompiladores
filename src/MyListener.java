import antlr.GramaticaBaseListener;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyListener extends GramaticaBaseListener {

    private Map<String, String> tabelaSimbolos = new HashMap<>();
    private ErrosSemanticos erroDeclaracao = new ErrosSemanticos();
    private ErrosSemanticos erroFaltaDeclaracao = new ErrosSemanticos();
    private ErrosSemanticos erroOperando = new ErrosSemanticos();
    private ErrosSemanticos erroAtribuicao = new ErrosSemanticos();
    private ErrosSemanticos erroComparacao = new ErrosSemanticos();

    @Override
    public void exitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx) {
        int linha = ctx.ID().getSymbol().getLine();

        String tipo = ctx.TIPO().getText();
        String id = ctx.ID().getText();
        if (tabelaSimbolos.containsKey(id)) {
            erroDeclaracao.addErro("A variável " + id + " declarada na linha " + linha + " já havia sido declarada");
        } else {
            tabelaSimbolos.put(id, tipo);
        }
    }

    @Override
    public void exitNAtribuicao(GramaticaParser.NAtribuicaoContext ctx) {
        for (TerminalNode id : ctx.ID()) {
            getFaltaDeclaracao(id);
        }

        getAtribuicaoIncompativel(ctx);

        ArrayList<TerminalNodeImpl> children = this.getChildren(ctx.getChild(1));

        if (ctx.getChild(1).getClass().getSimpleName().equals("NComparacaoContext")) {
            GramaticaParser.NComparacaoContext comparacaoContext = (GramaticaParser.NComparacaoContext) ctx.getChild(1);

            int linha = comparacaoContext.start.getLine();

            String[] primeiro = getTipo(comparacaoContext.operando(0));
            String[] segundo = getTipo(comparacaoContext.operando(1));
            if (!primeiro[1].equals(segundo[1])) {
                erroComparacao.addErro("Na linha " + linha +
                        " não é possível fazer a comparação, pois " + primeiro[0] +
                        " é do tipo " + primeiro[1] + " e " + segundo[0] + " é do tipo "
                        + segundo[1]
                );
            }
        } else if (ctx.getChild(1).getClass().getSimpleName().equals("NOperacaoContext")) {
            Map<String, String> tabelaTipos = new HashMap<>();
            boolean repetido = false;

            for (int i = 0; i < children.size(); i += 2) {
                String valor = children.get(i).getText().replace(",", ".");

                if (tabelaSimbolos.containsKey(valor)) {
                    tabelaTipos.put(valor, tabelaSimbolos.get(valor));
                    repetido = true;

                } else if (isNumeric(valor)) {
                    String tipo;

                    if (valor.indexOf('.') != -1) {
                        tipo = "float";
                    } else {
                        tipo = "int";
                    }

                    tabelaTipos.put(valor, tipo);
                }
            }

            if (repetido) {
                GramaticaParser.NOperacaoContext operacaoContext = (GramaticaParser.NOperacaoContext) ctx.getChild(1);
                int linha = operacaoContext.start.getLine();
                erroOperando.addErro("Na linha " + linha + " não podem haver operandos de tipos diferentes\n" + tabelaTipos);
            }

        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private String[] getTipo(GramaticaParser.OperandoContext ctx) {
        String valor = null;
        String tipo = null;

        if (ctx.ID() != null) {
            valor = ctx.ID().getText();
            if (tabelaSimbolos.containsKey(valor)) {
                tipo = tabelaSimbolos.get(valor);
            }
        } else if (ctx.NUM() != null) {
            valor = ctx.NUM().getText();

            if (valor.indexOf(',') != -1) {
                tipo = "float";
            } else {
                tipo = "int";
            }
        }

        return new String[] {valor, tipo};
    }

    private ArrayList<TerminalNodeImpl> getChildren(ParseTree ctx) {
        ArrayList<TerminalNodeImpl> children = new ArrayList<>();

        if (ctx.getChildCount() == 0) {
            children.add((TerminalNodeImpl) ctx);

        } else {
            for (int i = 0; i < ctx.getChildCount(); ++i) {
                children.addAll(getChildren(ctx.getChild(i)));
            }

        }

        return children;
    }

    @Override
    public void exitOperando(GramaticaParser.OperandoContext ctx) {
        getFaltaDeclaracao(ctx.ID());
    }

    private void getAtribuicaoIncompativel(GramaticaParser.NAtribuicaoContext ctx) {
        String tipo = null;
        String valor = null;

        if (ctx.STRING() != null) {
            tipo = "string";
            valor = ctx.STRING().getText();
        } else if (ctx.NUM() != null) {
            if (ctx.NUM().getText().indexOf(',') != -1) {
                tipo = "float";
            } else {
                tipo = "int";
            }

            valor = ctx.NUM().getText();
        }

        String tipoVar = ctx.ID().get(ctx.ID().size() - 1).getText();

        if (tipo != null && !tabelaSimbolos.get(tipoVar).equals(tipo)) {
            erroAtribuicao.addErro("Não é possível atribuir " + valor + " do tipo " + tipo + " à variável " + tipoVar + " do tipo " + tabelaSimbolos.get(tipoVar));
        }
    }

    private void getFaltaDeclaracao(TerminalNode ctxId) {
        if (ctxId != null && !tabelaSimbolos.containsKey(ctxId.getText())) {
            int linha = ctxId.getSymbol().getLine();
            String id = ctxId.getText();

            erroFaltaDeclaracao.addErro("A variável " + id + " utilizada na linha " + linha + " não foi declarada");
        }
    }

    @Override
    public void exitBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx) {
        erroDeclaracao.imprimirErros();
        erroFaltaDeclaracao.imprimirErros();
        erroAtribuicao.imprimirErros();
        erroOperando.imprimirErros();
        erroComparacao.imprimirErros();


        System.out.println("\nErros de declaração: " + erroDeclaracao.getQuantidade());
        System.out.println("Erros de variável não declarada: " + erroFaltaDeclaracao.getQuantidade());
        System.out.println("Erros de atribuição ao tipo errado: " + erroAtribuicao.getQuantidade());
        System.out.println("Erros de operação com tipos diferentes: " + erroOperando.getQuantidade());
        System.out.println("Erros de comparação com tipos diferentes: " + erroComparacao.getQuantidade());
        System.out.println("Erros totais: "
                + (erroDeclaracao.getQuantidade()
                + erroFaltaDeclaracao.getQuantidade()
                + erroAtribuicao.getQuantidade()
                + erroOperando.getQuantidade()
                + erroComparacao.getQuantidade()));
    }

    public Map<String, String> getTabelaSimbolos() {
        return tabelaSimbolos;
    }
}
