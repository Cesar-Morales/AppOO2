import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Roots implements TipoDeSuelo {

    private final List<String> cultivosAptos;

    public Roots(){
        String cultivos = "Papa, nabo, jengibre, batata, cúrcuma, remolacha, mandioca";
        List<String> cultivosAptosAux = Arrays.asList(cultivos.split(","));
        cultivosAptos = cultivosAptosAux.stream().map(c -> c.toLowerCase()).collect(Collectors.toList());
    }

    public boolean puedePlantarse(Cultivo cultivo, Double humedad) { 
        return cultivosAptos.stream().anyMatch(c -> c.contains(cultivo.getName().toLowerCase()));
    }

}
