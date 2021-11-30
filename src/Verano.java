
public class Verano extends EstacionDelAnio {
	
	private static Verano VERANO;
	
	private Verano() {
		setTemperaturaMax(35);
		setTemperaturaMin(19);
		setPromedioHumedad(51);
		setPromedioLluvias(31);
		setPromedioViento(17);
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
		int temperatura = c.getTemperatura();
		if (temperatura >= getTemperaturaMin() && temperatura <= getTemperaturaMax()) {			
			return true;
		}
		return false;
	}

}