//BEAN CULTIVO
public class Cultivo {
	
	private String nombre;
	private Integer durezaDondePuedeSerPlantado;
	private Integer humedadDondePuedeSerPlantado;
	private String familiaDeCultivos;
	private Integer temperatura;
	private Integer resistenciaDeCultivo;
	private Integer cantidadRiego;
	
	public Cultivo(String nombre, Integer durezaDondePuedeSerPlantado, Integer humedadDondePuedeSerPlantado,
			String familiaDeCultivos, Integer temperatura, Integer resistenciaDeCultivo, Integer cantidadRiego) {
		super();
		this.nombre = nombre;
		this.durezaDondePuedeSerPlantado = durezaDondePuedeSerPlantado;
		this.humedadDondePuedeSerPlantado = humedadDondePuedeSerPlantado;
		this.familiaDeCultivos = familiaDeCultivos;
		this.temperatura = temperatura;
		this.resistenciaDeCultivo = resistenciaDeCultivo;
		this.cantidadRiego = cantidadRiego;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDurezaDondePuedeSerPlantado() {
		return durezaDondePuedeSerPlantado;
	}

	public void setDurezaDondePuedeSerPlantado(Integer durezaDondePuedeSerPlantado) {
		this.durezaDondePuedeSerPlantado = durezaDondePuedeSerPlantado;
	}

	public Integer getHumedadDondePuedeSerPlantado() {
		return humedadDondePuedeSerPlantado;
	}

	public void setHumedadDondePuedeSerPlantado(Integer humedadDondePuedeSerPlantado) {
		this.humedadDondePuedeSerPlantado = humedadDondePuedeSerPlantado;
	}

	public String getFamiliaDeCultivos() {
		return familiaDeCultivos;
	}

	public void setFamiliaDeCultivos(String familiaDeCultivos) {
		this.familiaDeCultivos = familiaDeCultivos;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getResistenciaDeCultivo() {
		return resistenciaDeCultivo;
	}

	public void setResistenciaDeCultivo(Integer resistenciaDeCultivo) {
		this.resistenciaDeCultivo = resistenciaDeCultivo;
	}

	public Integer getCantidadRiego() {
		return cantidadRiego;
	}

	public void setCantidadRiego(Integer cantidadRiego) {
		this.cantidadRiego = cantidadRiego;
	}
	
	
}
