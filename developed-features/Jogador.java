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

        System.out.println("\nMão do " + nome + ":");

        for (int i = 0; i < mao.length; i++) {

            if (mao[i] != null) {

                System.out.println((i + 1) + " - " + mao[i].getValor() + " de " + mao[i].getNaipe());

            }

        }
    }

    public Baralho jogarCarta(int escolha){

        int indice = escolha - 1;

        if (indice < 0 || indice >= mao.length) {

            System.out.println("Escolha inválida!");
            return null;

        }

        if (mao[indice] == null) {

            System.out.println("Essa carta já foi usada!");
            return null;

        }

        Baralho cartaJogada = mao[indice];

        mao[indice] = null; // REMOVE A CARTA DA MÃO

        return cartaJogada;
    }

    public void setPontuacao(int pontos)
    {
        this.pontuacao = pontos;
    }
    public int getPontuacao()
    {
        return this.pontuacao;
    }

}