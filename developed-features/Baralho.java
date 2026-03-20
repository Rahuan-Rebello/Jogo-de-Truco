import java.util.Arrays;
import java.util.List;
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

    public void inicializarBaralho() {
        
        int contador = 0;

        for(String c : Cartas.getCartas())
        {
            for(String n : Cartas.getNaipes())
            {
                baralho[contador] = new Baralho(c, n);
                contador++;
            }
        }
        System.out.println("%nBaralho iniciado com " + contador + "cartas");
    }
}
