import java.util.List;

public class Primavera extends EstacionDelAnio {
	
	private static Primavera PRIMAVERA;
	
	private Primavera() {
		super(27.0, 14.0, 13.0, 26.0, 25.0, List.of(10,11,12));
	}

	public static Primavera getSingletonInstance() {
		if(PRIMAVERA == null) {
			PRIMAVERA = new Primavera();
		} else {
			System.out.println("Primavera creada");
		}
		return PRIMAVERA;
	}
	
	protected void cambiarASiguienteEstacion(){
		Quinta.setEstacion(Verano.getSingletonInstance());
	}

	protected boolean evaluarEnSiguienteEstacion(Cultivo c){
		return Verano.getSingletonInstance().puedePlantarseEnEstacion(c);
	}

	@Override
	public boolean cultivoApto(Cultivo c) {
		Double humedad = c.getHumedadOptima();
		if (humedad >= getPromedioHumedad()-3.0 && humedad <= getPromedioHumedad()+3.0) {			
			return true;
		}
		return false;
	}

}
