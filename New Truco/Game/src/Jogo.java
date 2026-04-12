import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== JOGO DE TRUCO =====");

        System.out.print("Nome do Jogador 1: ");
        String nome1 = sc.nextLine();

        System.out.print("Nome do Jogador 2: ");
        String nome2 = sc.nextLine();

        Jogador j1 = new Jogador(0, nome1);
        Jogador j2 = new Jogador(0, nome2);

        int valorRodada = 1;

        Baralho baralho = new Baralho("", "", 0);

        baralho.inicializarBaralho();
        baralho.embaralhar();

        for (int i = 0; i < 3; i++) {

            j1.getBaralhoJogador(baralho.getBaralho()[i], i);
            j2.getBaralhoJogador(baralho.getBaralho()[i + 3], i);

        }

        baralho.definirVira();
        String manilha = baralho.identificarManilha();

        int pontosJ1 = 0;
        int pontosJ2 = 0;

        System.out.println("\n" + nome1 + " quer pedir TRUCO? (s/n)");
        String truco = sc.nextLine();

        if (truco.equalsIgnoreCase("s")) {

            System.out.println(nome2 + ", aceitar truco? (s/n)");
            String aceita = sc.nextLine();

            if (aceita.equalsIgnoreCase("s")) {

                valorRodada = 3;
                System.out.println("TRUCO ACEITO! Rodada vale 3 pontos.");

            } else {

                System.out.println(nome2 + " correu!");
                System.out.println(nome1 + " ganha 1 ponto.");
                sc.close();
                return;
            }
        }

        for (int rodada = 0; rodada < 3; rodada++) {

            System.out.println("\n--- Vaza " + (rodada + 1) + " ---");

            Baralho cartaJ1 = null;

            while (cartaJ1 == null) {

                j1.mostrarMao();
                System.out.print(nome1 + ", escolha carta (1-3): ");

                int escolha1 = sc.nextInt();

                cartaJ1 = j1.jogarCarta(escolha1);

            }

            Baralho cartaJ2 = null;

            while (cartaJ2 == null) {

                j2.mostrarMao();
                System.out.print(nome2 + ", escolha carta (1-3): ");

                int escolha2 = sc.nextInt();

                cartaJ2 = j2.jogarCarta(escolha2);

            }

            System.out.println("\n" + nome1 + " jogou: " + cartaJ1.getValor() + " de " + cartaJ1.getNaipe());
            System.out.println(nome2 + " jogou: " + cartaJ2.getValor() + " de " + cartaJ2.getNaipe());

            int forca1 = cartaJ1.calcularForcaReal(manilha);
            int forca2 = cartaJ2.calcularForcaReal(manilha);

            if (forca1 > forca2) {

                System.out.println(nome1 + " ganhou a vaza!");
                pontosJ1++;

            }
            else if (forca2 > forca1) {

                System.out.println(nome2 + " ganhou a vaza!");
                pontosJ2++;

            }
            else {

                System.out.println("EMBUCHOU!");

            }

            if (pontosJ1 == 2 || pontosJ2 == 2) {
                break;
            }
        }

        System.out.println("\n===== RESULTADO =====");

        if (pontosJ1 > pontosJ2) {

            System.out.println(nome1 + " venceu a rodada e ganhou " + valorRodada + " pontos!");

        }
        else if (pontosJ2 > pontosJ1) {

            System.out.println(nome2 + " venceu a rodada e ganhou " + valorRodada + " pontos!");

        }
        else {

            System.out.println("Rodada empatada!");

        }

        sc.close();
    }
}