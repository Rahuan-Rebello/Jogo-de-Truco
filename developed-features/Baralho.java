import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baralho 
{
    private String valor;
    private String naipe;
    private int forca;
    private Baralho vira;
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

    public void definirVira() {
    if (this.baralho != null && this.baralho.length > 0) {
        this.vira = this.baralho[0]; 
        System.out.println("--- VIRA DA RODADA ---");
        System.out.println(vira.valor + " de " + vira.naipe);
        System.out.println("A manilha é: " + identificarManilha());
        System.out.println("-----------------------");
    }
}

    public String identificarManilha() {
    List<String> ordem = Cartas.getCartas();
    
    int indiceVira = ordem.indexOf(this.vira.valor);
    
    int indiceManilha = (indiceVira + 1) % ordem.size();
    
    return ordem.get(indiceManilha);
    }

    public int calcularForcaReal(String valorManilha) {

    if (!this.valor.equals(valorManilha)) {
        return this.forca; 
    }
    
      switch (this.naipe) {
        case "Paus":    return 100;
        case "Copas":   return 90;
        case "Espadas": return 80;
        case "Ouros":   return 70;
        default:        return this.forca;
    }
}    

    public Baralho getValor()
    {
        return this.valor;
    }
    public Baralho getNaipe()
    {
        return this.naipe;
    }

}
