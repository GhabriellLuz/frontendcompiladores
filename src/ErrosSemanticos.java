import java.util.ArrayList;
import java.util.List;

public class ErrosSemanticos {
    private int quantidade;
    private List<String> mensagens;


    public ErrosSemanticos() {
        this.quantidade = 0;
        this.mensagens = new ArrayList<>();
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void addErro(String mensagem) {
        this.mensagens.add(mensagem);
        this.quantidade += 1;
    }

    public void imprimirErros() {
        System.out.println();
        for (int i = 0; i < quantidade; i++) {
            System.out.println(mensagens.get(i));
        }
    }
}
