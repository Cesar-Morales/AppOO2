public class Primavera extends EstacionDelAnio {
	
	private static Primavera PRIMAVERA;
	
	private Primavera() {
		setHumedad(80);
		setTemperatura(20);
	}

	public static Primavera getSingletonInstance() {
		if(PRIMAVERA == null) {
			PRIMAVERA = new Primavera();
		} else {
			System.out.println("Primavera creada");
		}
		return PRIMAVERA;
	}
	

	@Override
	public boolean cultivoApto(Cultivo c) {
		return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
	}

}
