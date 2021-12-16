import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

public abstract class EstacionDelAnio {

	private Double temperaturaMax,
				   temperaturaMin,
				   promedioHumedad, 
				   promedioLluvias, 
				   promedioViento;
				
	private List<Integer> meses;

	private static Supplier<Calendar> currentTimeSupplier = Calendar::getInstance;

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

	protected EstacionDelAnio(Double temperaturaMax,
							  Double temperaturaMin,
							  Double promedioHumedad,
							  Double promedioLluvias,
							  Double promedioViento,
							  List<Integer> meses,
							  Supplier<Calendar> currentTimeSupplier){
		this(temperaturaMax,
		temperaturaMin,
		promedioHumedad,
		promedioLluvias,
		promedioViento,
		meses);
		setCurrentTimeSupplier(currentTimeSupplier);
	}

	protected boolean terminoLaEstacion(){
		return getMeses().contains(calcularMes()) ? false : true;
	}

	protected Calendar calendarioActual(){
		return currentTimeSupplier.get();
	}

	protected Integer calcularMes(){
		return calendarioActual().get(Calendar.MONTH) + 1;
	}

	public boolean puedePlantarseEnEstacion(Cultivo cultivo){
		if(terminoLaEstacion()){
			return evaluarEnSiguienteEstacion(cultivo);
		}
		else{
			return cultivoApto(cultivo);
		}
	}

	protected abstract boolean evaluarEnSiguienteEstacion(Cultivo cultivo);

	protected abstract boolean cultivoApto(Cultivo c);
	
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

	protected List<Integer> getMeses() {
        return meses;
    }

    protected void setMeses(List<Integer> meses) {
        this.meses = meses;
    }

    protected void setCurrentTimeSupplier(Supplier<Calendar> newCurrentTimeSupplier) {
        currentTimeSupplier = newCurrentTimeSupplier;
    }	

}
