
public class Verano extends EstacionDelAnio {
	
	private static Verano VERANO;
	
	private Verano() {
		setTemperaturaMax(35.0);
		setTemperaturaMin(19.0);
		setPromedioHumedad(51.0);
		setPromedioLluvias(31.0);
		setPromedioViento(17.0);
	}
	
	public static Verano getSingletonInstance(){
		if ( VERANO == null ) {
			VERANO = new Verano();
		} else {
			System.out.println("Verano creado");
		}
		return VERANO;
	}

	@Override
	boolean cultivoApto(Cultivo c) {
		Double temperatura = c.getTemperaturaOptima();
		if (temperatura >= getTemperaturaMin() && temperatura <= getTemperaturaMax()) {			
			return true;
		}
		return false;
	}

}