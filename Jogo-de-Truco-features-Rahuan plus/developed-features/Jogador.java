import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jogador {
    private int pontuacao;
    private String nome;
    private Baralho[] mao = new Baralho[3];

    public Jogador(int pontuacao, String nome)
    {
        this.pontuacao = pontuacao;
        this.nome = nome;
    }

    public void getBaralhoJogador(Baralho carta, int posicao)
    {
        if (posicao >= 0 && posicao < 3)
            {
                this.mao[posicao] = carta; 
            }
    }

    public void mostrarMao() {
        System.out.println("Mão do " + nome + ":");
        for (Baralho c : mao) {
            if (c != null) {
                System.out.println("- " + c.getValor() + " de " + c.getNaipe());
            }
        }
    }
}