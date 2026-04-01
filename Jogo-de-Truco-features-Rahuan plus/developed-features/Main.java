public class Main {
    public static void main(String[] args) {

        Baralho baralho = new Baralho("", "", 0);

        baralho.inicializarBaralho();

        System.out.println("\n--- BARALHO ORIGINAL ---");
        baralho.mostrarBaralho();

        baralho.embaralhar();

        System.out.println("\n--- BARALHO EMBARALHADO ---");
        baralho.mostrarBaralho();

        baralho.definirVira();

        Jogador j1 = new Jogador(0, "Jogador 1");
        Jogador j2 = new Jogador(0, "Jogador 2");


        for (int i = 0; i < 3; i++) {
            j1.getBaralhoJogador(baralho.getBaralho()[i], i);
            j2.getBaralhoJogador(baralho.getBaralho()[i + 3], i);
        }

        System.out.println("\n--- MÃOS DOS JOGADORES ---");
        j1.mostrarMao();
        j2.mostrarMao();
    }
}