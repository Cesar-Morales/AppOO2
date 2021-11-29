public class Otonio extends EstacionDelAnio {
	
	private static Otonio OTONIO;
	
	private Otonio() {
		setHumedad(20);
		setTemperatura(5);
	}
	
	public static Otonio getSingletonInstance() {
		if (OTONIO == null) {
			OTONIO = new Otonio();
		} else {
			System.out.println("Otonio creado");
		}
		return OTONIO;
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
	}

}
