
public class Verano extends EstacionDelAnio {
	
	Verano() {
		setHumedad(90);
		setTemperatura(35);
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
	}

}