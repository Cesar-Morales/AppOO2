
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Quinta {

	private Map<String,Espacio> espacios;
	private EstacionDelAnio estacion;    //STATE
	private Set<Espacio> tiposEspacios;
	private String nombre;
	
	public Quinta(String nombre) {
		setNombre(nombre);
		setEspacios(new HashMap<String, Espacio>());
		setEstacion(calcularEstacion());
		setTiposEspacios(new HashSet<Espacio>());
	}
	
	private EstacionDelAnio calcularEstacion() {
		//hardcodeado 
		//TODO: calcular realmente la epoca usando Test.java
		return new Otonio();
	}
	
	void agregarEspacio(Espacio e) {
		tiposEspacios.add(e);
	}
	
	public void eliminarEspacio(Espacio e) {
		tiposEspacios.remove(e);
	}
	
	public List<Espacio> listarEspacios(){
		return new ArrayList<Espacio>(tiposEspacios);
	}
	
	
	/* Getters and Setters */

	public Map<String,Espacio> getEspacios() {
		return espacios;
	}

	public void setEspacios(Map<String,Espacio> espacios) {
		this.espacios = espacios;
	}

	public EstacionDelAnio getEstacion() {
		return estacion;
	}

	public void setEstacion(EstacionDelAnio estacion) {
		this.estacion = estacion;
	}

	public Set<Espacio> getTiposEspacios() {
		return tiposEspacios;
	}

	public void setTiposEspacios(Set<Espacio> tiposEspacios) {
		this.tiposEspacios = tiposEspacios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* Fin Getters and Setters */

}
