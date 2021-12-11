import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

public class Verano extends EstacionDelAnio {
	
	private static Verano VERANO;
	
	private Verano() {
		super(35.0, 19.0, 51.0, 31.0, 17.0, List.of(1,2,3));
	}

	protected Verano(Supplier<Calendar> suplier) {
		super(35.0, 19.0, 51.0, 31.0, 17.0, List.of(1,2,3), suplier);
	}
	
	public static Verano getSingletonInstance(){
		if ( VERANO == null ) {
			VERANO = new Verano();
		}
		return VERANO;
	}

	protected EstacionDelAnio obtenerSiguienteEstacion(){
		return Otonio.getSingletonInstance();
	}

	protected boolean evaluarEnSiguienteEstacion(Cultivo c){
		return Otonio.getSingletonInstance().puedePlantarseEnEstacion(c);
	}

	@Override
	protected boolean cultivoApto(Cultivo c) {
		Double temperatura = c.getTemperaturaOptima();
		if (temperatura >= getTemperaturaMin() && temperatura <= getTemperaturaMax()) {			
			return true;
		}
		return false;
	}

}