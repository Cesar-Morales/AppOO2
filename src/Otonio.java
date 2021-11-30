public class Otonio extends EstacionDelAnio {
	
	private static Otonio OTONIO;
	
	private Otonio() {
		setTemperaturaMax(21);
		setTemperaturaMin(9);
		setPromedioHumedad(13);
		setPromedioLluvias(26);
		setPromedioViento(18);
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
		int resistencia  = c.getResistenciaDeCultivo();
		if (resistencia >= getPromedioViento()) {			
			return true;
		}
		return false;
	}

}
