import java.util.List;

public class Invierno extends EstacionDelAnio {
		
		private static Invierno INVIERNO;
	
		private Invierno() {
			super(18.0, 6.0, 0.0, 17.0, 20.0, List.of(7,8,9));
		}
		
		public static Invierno getSingletonInstance() {
			if (INVIERNO == null) {
				INVIERNO = new Invierno();
			} else {
				System.out.println("Invierno creado");
			}
			return INVIERNO;
		}

		protected void cambiarASiguienteEstacion(){
			Quinta.setEstacion(Primavera.getSingletonInstance());
		}

		protected boolean evaluarEnSiguienteEstacion(Cultivo c){
			return Primavera.getSingletonInstance().puedePlantarseEnEstacion(c);
		}

		@Override
		public boolean cultivoApto(Cultivo c) {
			Double riego = c.getCantidadRiego();
			Double temperatura = c.getTemperaturaOptima();
			if (riego >= getPromedioLluvias() && temperatura >= getTemperaturaMin()) {			
				return true;
			}
			return false;
		}

}

