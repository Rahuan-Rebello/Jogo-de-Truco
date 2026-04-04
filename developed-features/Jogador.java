import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    public Baralho jogarCarta(int escolha){
        switch (escolha) {
            case 1: return this.mao[0];
            case 2: return this.mao[1];
            case 3: return this.mao[2];
            default:
                System.out.println("Erro! Escolha um número de 1 a 3!");
                return null;
        }
    }

}