public class HumedadBaja extends HumedadDelSuelo{

    @Override
    boolean puedePlantarse(String cultivo) {
        return (cultivo.equals("Tomate")) ? false : true;
    }

}
