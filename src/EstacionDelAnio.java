public abstract class EstacionDelAnio {
	private int promedioHumedad,temperaturaMax,temperaturaMin;
	private int promedioNubes, promedioLluvias, primedioSol, promedioViento;
	
	//PORCENTAJE
	public int getPromedioNubes() { 
		return promedioNubes;
	}


	public void setPromedioNubes(int promedioNublado) {
		this.promedioNubes = promedioNublado;
	}


	public int getPromedioLluvias() {
		return promedioLluvias;
	}


	public void setPromedioLluvias(int promedioLluvias) {
		this.promedioLluvias = promedioLluvias;
	}

	//EN HORAS
	public int getPrimedioSol() {
		return primedioSol;
	}


	public void setPrimedioSol(int primedioSol) {
		this.primedioSol = primedioSol;
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
