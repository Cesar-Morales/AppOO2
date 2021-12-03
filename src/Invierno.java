public class Invierno extends EstacionDelAnio {
		
		private static Invierno INVIERNO;
	
		private Invierno() {
			setTemperaturaMax(18.0);
			setTemperaturaMin(6.0);
			setPromedioHumedad(0.0);
			setPromedioLluvias(17.0);
			setPromedioViento(20.0);
		}
		
		public static Invierno getSingletonInstance() {
			if (INVIERNO == null) {
				INVIERNO = new Invierno();
			} else {
				System.out.println("Invierno creado");
			}
			return INVIERNO;
		}

		@Override
		boolean cultivoApto(Cultivo c) {
			Double riego = c.getCantidadRiego();
			Double temperatura = c.getTemperaturaOptima();
			if (riego >= getPromedioLluvias() && temperatura >= getTemperaturaMin()) {			
				return true;
			}
			return false;
		}

}

