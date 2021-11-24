public class Invierno extends EstacionDelAnio {
		
		Invierno() {
			setHumedad(10);
			setTemperatura(-5);
		}

		@Override
		public boolean cultivoApto(Cultivo c) {
			return (c.getHumedadDondePuedeSerPlantado()).equals(getHumedad());
		}

}

