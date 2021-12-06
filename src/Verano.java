import java.util.List;

public class Verano extends EstacionDelAnio {
	
	private static Verano VERANO;
	
	private Verano() {
		super(35.0, 19.0, 51.0, 31.0, 17.0, List.of(1,2,3));
	}
	
	public static Verano getSingletonInstance(){
		if ( VERANO == null ) {
			VERANO = new Verano();
		} else {
			System.out.println("Verano creado");
		}
		return VERANO;
	}

	protected void cambiarASiguienteEstacion(){
		Quinta.setEstacion(Otonio.getSingletonInstance());
	}

	protected boolean evaluarEnSiguienteEstacion(Cultivo c){
		return Otonio.getSingletonInstance().puedePlantarseEnEstacion(c);
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		Double temperatura = c.getTemperaturaOptima();
		if (temperatura >= getTemperaturaMin() && temperatura <= getTemperaturaMax()) {			
			return true;
		}
		return false;
	}

}