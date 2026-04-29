import java.util.Scanner;

public class Truco {

    private int contTruco = 0;

    public int pedirTruco(String nome1, String nome2, Jogador jogador1, Jogador jogador2, int pontosAnteriores)
    {
        Scanner sc = new Scanner(System.in);

        int pontuacaoAoCorrer = 3 * this.contTruco;

        this.contTruco++;

        int valorRodada = 3 * this.contTruco;

        while(true) {
                jogador2.mostrarMao();
                System.out.println("\n" + nome2 + ", aceitar? (s/n) - OU AUMENTAR A APOSTA!? (aperte 'A' para aumentar!)");
                System.out.println("Pontuação atual da rodada:" + valorRodada);
                String aceita = sc.nextLine().toLowerCase();

                
                    switch (aceita) {
                    case "s":
                        System.out.println("ACEITO! Rodada vale " + valorRodada + " pontos.");
                        jogador1.mostrarMao();
                        jogador2.mostrarMao();
                        return valorRodada;
                    case "n":
                        if (this.contTruco == 1)
                            {
                                System.out.println(nome2 + " correu!");
                                System.out.println(nome1 + " ganha " + this.contTruco);
                                jogador1.setPontuacao(pontosAnteriores + this.contTruco);
                                this.contTruco = 0;
                                return 0;
                            }                     
                        else{
                                System.out.println(nome2 + " correu!");
                                System.out.println(nome1 + " ganha " + pontuacaoAoCorrer);
                                this.contTruco = 0;
                                jogador1.setPontuacao(pontosAnteriores + pontuacaoAoCorrer);
                                return 0;
                            }
                    case "a":
                            if(valorRodada >= 12) {
                                System.out.println("\nPontuação máxima atingida (12)! Não é mais possível aumentar a aposta!");
                                return valorRodada;
                            }
                            else{
                                return pedirTruco(nome2, nome1, jogador2, jogador1, jogador2.getPontuacao());
                            }
                
                    default:
                        System.out.println("Digite uma opção válida");
                        break;
                }
            }                      
    }

    public void setContTruco(int reset)
    {
        this.contTruco = reset;
    }

}    
