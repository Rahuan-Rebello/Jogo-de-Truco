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

        Truco truco = new Truco();


    while (j1.getPontuacao() <= 11 && j2.getPontuacao() <= 11) {        
            Baralho baralho = new Baralho("", "", 0);

            baralho.inicializarBaralho();
            baralho.embaralhar();

            int vazasGanhasJ1 = 0;
            int vazasGanhasJ2 = 0;
            int valorRodada = 1;

            for (int i = 0; i < 3; i++) {

                j1.getBaralhoJogador(baralho.getBaralho()[i], i);
                j2.getBaralhoJogador(baralho.getBaralho()[i + 3], i);

            }

            baralho.definirVira();
            String manilha = baralho.identificarManilha();

            boolean alguemCorreu = false;

            for (int rodada = 0; rodada < 3; rodada++) {
                if (alguemCorreu) break; 

                System.out.println("\n--- Vaza " + (rodada + 1) + " ---");

                Baralho cartaJ1 = null;

                while (cartaJ1 == null) {

                    j1.mostrarMao();
                    System.out.println("Pontuação atual do " + nome1 + ": " + j1.getPontuacao());

                        System.out.println("\n" + nome1 + " quer pedir TRUCO? (s/n)");
                        String trucolt = sc.nextLine();
                        
                        if(valorRodada == 12)
                        {
                            System.out.println("\nA rodada já vale 12! \n");
                        }
                        else{
                            if (trucolt.equalsIgnoreCase("s")) {
                                valorRodada = truco.pedirTruco(nome1, nome2, j1, j2, j1.getPontuacao());
                                if(valorRodada == 0)
                                    {
                                        alguemCorreu = true;
                                        break;
                                    }
                                    
                                }
                            }

                    System.out.print(nome1 + ", escolha carta (1-3): ");

                    int escolha1 = sc.nextInt();
                    sc.nextLine();

                    cartaJ1 = j1.jogarCarta(escolha1);

                }

                if (alguemCorreu) break;

                Baralho cartaJ2 = null;

                while (cartaJ2 == null) {

                    j2.mostrarMao();
                    System.out.println("Pontuação atual do " + nome2 + ": " + j2.getPontuacao());

                    System.out.println("\n" + nome2 + " quer pedir TRUCO? (s/n)");
                        String trucolt = sc.nextLine();
                        if(valorRodada == 12)
                        {
                            System.out.println("\nA rodada já vale 12! \n");
                        }
                        else{
                            if (trucolt.equalsIgnoreCase("s")) {
                                valorRodada = truco.pedirTruco(nome2, nome1, j2, j1, j2.getPontuacao());
                                if(valorRodada == 0)
                                {
                                    alguemCorreu = true;
                                    break;
                                }
                            }
                        }

                    System.out.print(nome2 + ", escolha carta (1-3): ");

                    int escolha2 = sc.nextInt();
                    sc.nextLine();

                    cartaJ2 = j2.jogarCarta(escolha2);

                }

                if (alguemCorreu) break;

                System.out.println("\n" + nome1 + " jogou: " + cartaJ1.getValor() + " de " + cartaJ1.getNaipe());
                System.out.println("\n" + nome2 + " jogou: " + cartaJ2.getValor() + " de " + cartaJ2.getNaipe() + "\n\n");

                int forca1 = cartaJ1.calcularForcaReal(manilha);
                int forca2 = cartaJ2.calcularForcaReal(manilha);

                if (forca1 > forca2) {
                    vazasGanhasJ1++;
                    System.out.println(nome1 + " ganhou a vaza!");
                }
                else if (forca2 > forca1) {
                    vazasGanhasJ2++;
                    System.out.println(nome2 + " ganhou a vaza!");            
                }
                else {

                    System.out.println("EMBUCHOU!");

                }

                if (vazasGanhasJ1 == 2 || vazasGanhasJ2 == 2) break;

                if (j1.getPontuacao() >= 12 || j2.getPontuacao() >= 12) break;
            }

            System.out.println("\n===== RESULTADO =====\n");

            if (vazasGanhasJ1 > vazasGanhasJ2){

                System.out.println(nome1 + " venceu a rodada!\n");
                j1.setPontuacao(valorRodada + j1.getPontuacao());
                System.out.println("Jogador está com " + j1.getPontuacao() + " pontos");

            }
            else if (vazasGanhasJ2 > vazasGanhasJ1) {

                System.out.println(nome2 + " venceu a rodada!\n");
                j2.setPontuacao(valorRodada + j2.getPontuacao());
                System.out.println("Jogador está com " + j2.getPontuacao() + " pontos");
            }
            else {

                System.out.println("Rodada empatada!");
            }


            truco.setContTruco(0);

            if (j1.getPontuacao() >= 12 || j2.getPontuacao() >= 12) break;
        }

        System.out.println("\n\n\n=====RESULTADO DA PARTIDA=====\n\n");

        if(j1.getPontuacao() > j2.getPontuacao()) {
            System.out.println("\nJogador " + nome1 + " Farmou aura\n");
        }
        else if(j2.getPontuacao() > j1.getPontuacao()) {
            System.out.println("\nJogador " + nome2 + " Farmou aura\n");
        }

        sc.close();
    }

    
}