public class Invierno extends EstacionDelAnio {
		
		private static Invierno INVIERNO;
	
		private Invierno() {
			setTemperaturaMax(18);
			setTemperaturaMin(6);
			setPromedioHumedad(0);
			setPromedioLluvias(17);
			setPromedioViento(20);
		}
		
		public static Invierno getSingletonInstance() {
			if (INVIERNO == null) {
				INVIERNO = new Invierno();
			} else {
				System.out.println("Invierno creado");
			}
			return new Invierno();
		}

		@Override
		boolean cultivoApto(Cultivo c) {
			int riego = c.getCantidadRiego();
			int temperatura = c.getTemperatura();
			if (riego >= getPromedioLluvias() && temperatura >= getTemperaturaMin()) {			
				return true;
			}
			return false;
		}

}

