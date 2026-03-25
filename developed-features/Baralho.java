import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Baralho 
{
    private String valor;
    private String naipe;
    private int forca;
    private Baralho[] baralho = new Baralho[40];

    public Baralho(String valor, String naipe, int forca)
    {
        this.valor = valor;
        this.naipe = naipe;
        this.forca = forca;
    }

    public void inicializarBaralho() {
        
        int contador = 0;

        for(String c : Cartas.getCartas())
        {
            for(String n : Cartas.getNaipes())
            {
                baralho[contador] = new Baralho(c, n, contador + 1);
                contador++;
            }
        }
        System.out.println("%nBaralho iniciado com " + contador + "cartas");
    }

    public void mostrarBaralho() {
    for (Baralho c : baralho) {
        if (c != null) { 
            System.out.println(c.valor + " de " + c.naipe + " | Força: " + c.forca);
        }
    }
}

    public void embaralhar() {
        List<Baralho> listaAuxiliar = Arrays.asList(this.baralho);
        Collections.shuffle(listaAuxiliar);
        this.baralho = listaAuxiliar.toArray(new Baralho[0]);
        System.out.println("As cartas foram embaralhadas");
    }

    
}
