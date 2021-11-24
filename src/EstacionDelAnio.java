public abstract class EstacionDelAnio {
	private int humedad;
	private int temperatura;
	
	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public abstract boolean cultivoApto(Cultivo c);

	
}
