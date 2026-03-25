import java.util.Arrays;
import java.util.Collections;

public class Baralho 
{
    private String valor;
    private String naipe;
    private Baralho[] baralho = new Baralho[40];

    public Baralho(String valor, String naipe)
    {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Baralho() {}

    public void inicializarBaralho() {
        int contador = 0;

        for(String c : Cartas.getValores()) {
            for(String n : Cartas.getNaipes()) {
                baralho[contador] = new Baralho(c, n);
                contador++;
            }
        }

        System.out.println("Baralho iniciado com " + contador + " cartas");
    }

    public void embaralhar() {
        Collections.shuffle(Arrays.asList(baralho));
        System.out.println("Baralho embaralhado!");
    }

    public void mostrarBaralho() {
        for (Baralho carta : baralho) {
            System.out.println(carta.valor + " de " + carta.naipe);
        }
    }
}