
public class Verano extends EstacionDelAnio {
	
	private static Verano VERANO;
	
	private Verano() {
		setHumedad(90);
		setTemperatura(35);
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
	public boolean cultivoApto(Cultivo c) {
		return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
	}

}