import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

public class Invierno extends EstacionDelAnio {
		
		private static Invierno INVIERNO;
	
		private Invierno() {
			super(18.0, 6.0, 0.0, 17.0, 20.0, List.of(7,8,9));
		}

		protected Invierno(Supplier<Calendar> suplier) {
			super(18.0, 6.0, 0.0, 17.0, 20.0, List.of(7,8,9), suplier);
		}
		
		public static Invierno getSingletonInstance() {
			if (INVIERNO == null) {
				INVIERNO = new Invierno();
			}
			return INVIERNO;
		}

		protected boolean evaluarEnSiguienteEstacion(Cultivo cultivo){
			Quinta.setEstacion(Primavera.getSingletonInstance());
			return Primavera.getSingletonInstance().puedePlantarseEnEstacion(cultivo);
		}

		@Override
		protected boolean cultivoApto(Cultivo c) {
			Double riego = c.getCantidadRiego();
			Double temperatura = c.getTemperaturaOptima();
			if (riego >= getPromedioLluvias() && temperatura >= getTemperaturaMin()) {			
				return true;
			}
			return false;
		}

}

