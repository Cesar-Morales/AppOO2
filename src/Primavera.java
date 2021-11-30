public class Primavera extends EstacionDelAnio {
	
	private static Primavera PRIMAVERA;
	
	private Primavera() {
		setTemperaturaMax(27);
		setTemperaturaMin(14);
		setPromedioHumedad(13);
		setPromedioLluvias(26);
		setPromedioViento(25);
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
	boolean cultivoApto(Cultivo c) {
		int humedad = c.getHumedadDondePuedeSerPlantado();
		if (humedad >= getPromedioHumedad()-3 && humedad <= getPromedioHumedad()+3) {			
			return true;
		}
		return false;
	}

}
