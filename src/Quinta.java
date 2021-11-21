package modulos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quinta {

	private Map<String,Espacio> espacios;
	private EstacionDelAnio estacion;
	private Set<Espacio> tiposEspacios; 
	
	public Quinta() {
		setEspacios(new HashMap<String, Espacio>());
		setEstacion(new EstacionDelAnio());
		setTiposEspacios(new HashSet<Espacio>());
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

	/* Fin Getters and Setters */

}
