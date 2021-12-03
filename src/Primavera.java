public class Primavera extends EstacionDelAnio {
	
	private static Primavera PRIMAVERA;
	
	private Primavera() {
		setTemperaturaMax(27.0);
		setTemperaturaMin(14.0);
		setPromedioHumedad(13.0);
		setPromedioLluvias(26.0);
		setPromedioViento(25.0);
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
		Double humedad = c.getHumedadOptima();
		if (humedad >= getPromedioHumedad()-3.0 && humedad <= getPromedioHumedad()+3.0) {			
			return true;
		}
		return false;
	}

}
