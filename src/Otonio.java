public class Otonio extends EstacionDelAnio {
	
	Otonio() {
		setHumedad(20);
		setTemperatura(5);
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
	}

}
