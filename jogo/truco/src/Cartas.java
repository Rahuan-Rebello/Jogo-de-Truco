import java.util.List;

public final class Cartas {

    private Cartas() {}

    public static final List<String> VALORES = List.of(
        "4","5","6","7","Q","J","K","A","2","3"
    );

    public static final List<String> NAIPES = List.of(
        "Ouros", "Espadas", "Copas", "Paus"
    );

    public static List<String> getValores() {
        return VALORES;
    }

    public static List<String> getNaipes() {
        return NAIPES;
    }
}