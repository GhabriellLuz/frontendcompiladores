import antlr.GramaticaLexer;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class AnalisadorSemantico {
    public static void main(String[] args) {
        //parsing the input
        GramaticaParser parser = getParser("C:\\Users\\ghabr\\IdeaProjects\\compiladores\\src\\teste\\codigo.txt");

        //obter arvore
        ParseTree ast = parser.inicio();

        System.out.println(ast.toStringTree());

        //Inicia o MyListener, nossa implementação do baseListener
        MyListener listener = new MyListener();

        ParseTreeWalker walker = new ParseTreeWalker();

        //percorre a ast com a nossa implementação do listener
        walker.walk(listener, ast);
    }

    //método para executar o Lexer e o parser sobre o arquivo de entrada
    private static GramaticaParser getParser(String fileName) {
        GramaticaParser parser = null;
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            GramaticaLexer lexer = new GramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GramaticaParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }
}