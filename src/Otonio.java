public class Otonio extends EstacionDelAnio {
	
	private static Otonio OTONIO;
	
	private Otonio() {
		setTemperaturaMax(21.0);
		setTemperaturaMin(9.0);
		setPromedioHumedad(13.0);
		setPromedioLluvias(26.0);
		setPromedioViento(18.0);
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
	boolean cultivoApto(Cultivo c) {
		Double resistencia  = c.getResistenciaDeCultivo();
		if (resistencia >= getPromedioViento()) {			
			return true;
		}
		return false;
	}

}
