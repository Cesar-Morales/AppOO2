public abstract class EstacionDelAnio {
	
	private Integer promedioHumedad,temperaturaMax,temperaturaMin, promedioLluvias, promedioViento;
	
	public int getPromedioLluvias() {
		return promedioLluvias;
	}

	public void setPromedioLluvias(int promedioLluvias) {
		this.promedioLluvias = promedioLluvias;
	}

	public int getPromedioViento() {
		return promedioViento;
	}

	public void setPromedioViento(int promedioViento) {
		this.promedioViento = promedioViento;
	}

	public int getPromedioHumedad() {
		return  promedioHumedad;
	}

	public void setPromedioHumedad(int  promedioHumedad) {
		this. promedioHumedad =  promedioHumedad;
	}

	public int getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(int temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public int getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(int tempreraturaMin) {
		this.temperaturaMin = tempreraturaMin;
	}

	abstract boolean cultivoApto(Cultivo c);

}