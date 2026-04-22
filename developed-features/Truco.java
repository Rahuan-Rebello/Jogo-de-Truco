import java.util.Scanner;

public class Truco {

    private int contTruco = 1;

    public int pedirTruco(String nome1, String nome2, Jogador jogador1, Jogador jogador2, int pontosAnteriores)
    {
        Scanner sc = new Scanner(System.in);

        int valorRodada = 3 * this.contTruco;


                System.out.println(nome2 + ", aceitar? (s/n)");
                String aceita = sc.nextLine();

                if (aceita.equalsIgnoreCase("s")) {

                    System.out.println("ACEITO! Rodada vale " + valorRodada + " pontos.");

                    this.contTruco++;
                    return valorRodada;
                } 
                else {

                        if (contTruco == 1)
                            {
                                System.out.println(nome2 + " correu!");
                                System.out.println(nome1 + " ganha " + this.contTruco);
                                jogador1.setPontuacao(pontosAnteriores + this.contTruco);
                                return 0;
                            }
                            
                        else{
                                System.out.println(nome2 + " correu!");
                                System.out.println(nome1 + " ganha " + valorRodada);
                                jogador1.setPontuacao(pontosAnteriores + valorRodada);
                                this.contTruco = 1;
                                return 0;
                            }
                    }                         
    }

    public void setContTruco(int reset)
    {
        this.contTruco = reset;
    }
}    