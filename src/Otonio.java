import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

public class Otonio extends EstacionDelAnio {
	
	private static Otonio OTONIO;
	
	private Otonio() {
		super(21.0, 9.0, 13.0, 26.0, 18.0, List.of(4,5,6));
	}

	protected Otonio(Supplier<Calendar> suplier) {
		super(21.0, 9.0, 13.0, 26.0, 18.0, List.of(4,5,6), suplier);
	}
	
	public static Otonio getSingletonInstance() {
		if (OTONIO == null) {
			OTONIO = new Otonio();
		}
		return OTONIO;
	}

	protected EstacionDelAnio obtenerSiguienteEstacion(){
		return Invierno.getSingletonInstance();
	}

	protected boolean evaluarEnSiguienteEstacion(Cultivo c){
		return Invierno.getSingletonInstance().puedePlantarseEnEstacion(c);
	}

	@Override
	protected boolean cultivoApto(Cultivo c) {
		Double resistencia  = c.getResistenciaDeCultivo();
		if (resistencia >= getPromedioViento()) {			
			return true;
		}
		return false;
	}

}
