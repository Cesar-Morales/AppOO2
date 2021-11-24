
public class Cultivo {
	
	//Basicamente esto es una plantilla de las frutas y verduras
	//que va a tener el sistema, la cual debe tener ciertas
	//variables (cambiar nombres) que van a servir para
	//chequear donde pueden ser plantadas
	
	private String nombre;
	private Integer durezaDondePuedeSerPlantado;
	private Integer humedadDondePuedeSerPlantado;
	private String familiaDeCultivos;
	private Integer temperatura;	

	public String getNombre() {
		return nombre;
	}

	public Cultivo(String nombre, Integer durezaDondePuedeSerPlantado, Integer humedadDondePuedeSerPlantado,
			String familiaDeCultivos, Integer temperatura) {
		super();
		this.nombre = nombre;
		this.durezaDondePuedeSerPlantado = durezaDondePuedeSerPlantado;
		this.humedadDondePuedeSerPlantado = humedadDondePuedeSerPlantado;
		this.familiaDeCultivos = familiaDeCultivos;
		this.temperatura = temperatura;
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
	
	
}
