public class Primavera extends EstacionDelAnio {
	
	Primavera() {
		setHumedad(80);
		setTemperatura(20);
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
	}

}
