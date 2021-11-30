

public class BlackSoil implements TipoDeSuelo{

    private final Double phSuelo = 8.0;

    private Double getPhSuelo(){
        return phSuelo;
    }
    
    @Override
    public boolean puedePlantarse(Cultivo cultivo, Double humedad) {
        return humedad >= cultivo.getHumedadOptima() && cultivo.getPhOptimo() >= this.getPhSuelo();
    }


}
