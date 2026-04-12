import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Cartas {

    private static final List<String> CARTAS = List.of("4","5","6","7","Q","J","K","A","2","3");
    private static final List<String> NAIPES = List.of("Ouros", "Espadas", "Copas", "Paus");

    public static List<String> getCartas()
    {
        return CARTAS;
    }

    public static List<String> getNaipes()
    {
        return NAIPES;
    }

}   