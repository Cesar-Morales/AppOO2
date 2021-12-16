

public class BlackSoil implements TipoDeSuelo{

    private final double phSuelo = 8.0;

    private double getPhSuelo(){
        return phSuelo;
    }

	@Override
	public boolean puedePlantarse(Cultivo cultivo) {
		return cultivo.getPhOptimo() >= this.getPhSuelo();
	}

}
