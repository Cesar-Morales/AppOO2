public abstract class EstacionDelAnio {
	
	private Double promedioHumedad,
				   temperaturaMax,
				   temperaturaMin, 
				   promedioLluvias, 
				   promedioViento;
	
	public Double getPromedioLluvias() {
		return promedioLluvias;
	}

	public void setPromedioLluvias(Double promedioLluvias) {
		this.promedioLluvias = promedioLluvias;
	}

	public Double getPromedioViento() {
		return promedioViento;
	}

	public void setPromedioViento(Double promedioViento) {
		this.promedioViento = promedioViento;
	}

	public Double getPromedioHumedad() {
		return  promedioHumedad;
	}

	public void setPromedioHumedad(Double  promedioHumedad) {
		this. promedioHumedad =  promedioHumedad;
	}

	public Double getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(Double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public Double getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(Double tempreraturaMin) {
		this.temperaturaMin = tempreraturaMin;
	}

	abstract boolean cultivoApto(Cultivo c);

}