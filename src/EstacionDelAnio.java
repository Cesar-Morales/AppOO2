import java.util.Calendar;
import java.util.List;

public abstract class EstacionDelAnio {

	private Double temperaturaMax,
				   temperaturaMin,
				   promedioHumedad, 
				   promedioLluvias, 
				   promedioViento;
				
	private List<Integer> meses;

	//Refactorizados contructores de subclases
	protected EstacionDelAnio(Double temperaturaMax,
							  Double temperaturaMin,
							  Double promedioHumedad,
							  Double promedioLluvias,
							  Double promedioViento,
							  List<Integer> meses){
		setTemperaturaMax(temperaturaMax);
		setTemperaturaMin(temperaturaMin);
		setPromedioHumedad(promedioHumedad);
		setPromedioLluvias(promedioLluvias);
		setPromedioViento(promedioViento);
		setMeses(meses);
	}
	
	protected Double getPromedioLluvias() {
		return promedioLluvias;
	}

	protected void setPromedioLluvias(Double promedioLluvias) {
		this.promedioLluvias = promedioLluvias;
	}

	protected Double getPromedioViento() {
		return promedioViento;
	}

	protected void setPromedioViento(Double promedioViento) {
		this.promedioViento = promedioViento;
	}

	protected Double getPromedioHumedad() {
		return  promedioHumedad;
	}

	protected void setPromedioHumedad(Double  promedioHumedad) {
		this. promedioHumedad =  promedioHumedad;
	}

	protected Double getTemperaturaMax() {
		return temperaturaMax;
	}

	protected void setTemperaturaMax(Double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	protected Double getTemperaturaMin() {
		return temperaturaMin;
	}

	protected void setTemperaturaMin(Double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public List<Integer> getMeses() {
        return meses;
    }

    public void setMeses(List<Integer> meses) {
        this.meses = meses;
    }

	protected Calendar calendarioActual(){
		return Calendar.getInstance();
	}

	protected Integer calcularMes(){
		return calendarioActual().get(Calendar.MONTH) + 1;
	}

	//Refactorizado move method, renombrado, extarct method y replace temp with query.
	//Hablar porque el singleton está en cada clase concreta y no en la bases.
	//Hacer las transiciones en las sublcases para sacar el switch.

	protected boolean terminoLaEstacion(){
		return getMeses().contains(calcularMes()) ? false : true;
	}

	//Nuevo template method
	public boolean puedePlantarseEnEstacion(Cultivo c){
		if(terminoLaEstacion()){
			cambiarASiguienteEstacion();
			return evaluarEnSiguienteEstacion(c);
		}
		else{
			return cultivoApto(c);
		}
	}

	protected abstract boolean cultivoApto(Cultivo c);

	protected abstract void cambiarASiguienteEstacion();

	protected abstract boolean evaluarEnSiguienteEstacion(Cultivo c);

	

	

}