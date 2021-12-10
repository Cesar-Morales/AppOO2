import java.util.List;

public class Otonio extends EstacionDelAnio {
	
	private static Otonio OTONIO;
	
	private Otonio() {
		super(21.0, 9.0, 13.0, 26.0, 18.0, List.of(4,5,6));
	}
	
	public static Otonio getSingletonInstance() {
		if (OTONIO == null) {
			OTONIO = new Otonio();
		} else {
			System.out.println("Otonio creado");
		}
		return OTONIO;
	}

	protected void cambiarASiguienteEstacion(){
		Quinta.setEstacion(Invierno.getSingletonInstance());
	}

	protected boolean evaluarEnSiguienteEstacion(Cultivo c){
		return Invierno.getSingletonInstance().puedePlantarseEnEstacion(c);
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		Double resistencia  = c.getResistenciaDeCultivo();
		if (resistencia >= getPromedioViento()) {			
			return true;
		}
		return false;
	}

}
