public class Invierno extends EstacionDelAnio {
		
		private static Invierno INVIERNO;
	
		private Invierno() {
			setHumedad(10);
			setTemperatura(-5);
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
		public boolean cultivoApto(Cultivo c) {
			return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
		}

}

