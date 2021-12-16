import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

public class Primavera extends EstacionDelAnio {
	
	private static Primavera PRIMAVERA;
	
	private Primavera() {
		super(27.0, 14.0, 13.0, 26.0, 25.0, List.of(10,11,12));
	}

	protected Primavera(Supplier<Calendar> suplier) {
		super(27.0, 14.0, 13.0, 26.0, 25.0, List.of(10,11,12), suplier);
	}

	public static Primavera getSingletonInstance() {
		if(PRIMAVERA == null) {
			PRIMAVERA = new Primavera();
		}
		return PRIMAVERA;
	}

	protected boolean evaluarEnSiguienteEstacion(Cultivo cultivo){
		Quinta.setEstacion(Verano.getSingletonInstance());
		return Verano.getSingletonInstance().puedePlantarseEnEstacion(cultivo);
	}

	@Override
	protected boolean cultivoApto(Cultivo c) {
		Double humedad = c.getHumedadOptima();
		if (humedad >= getPromedioHumedad()-3.0 && humedad <= getPromedioHumedad()+3.0) {			
			return true;
		}
		return false;
	}

}
