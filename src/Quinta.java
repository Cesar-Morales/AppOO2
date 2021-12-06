
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Esto tambien debería ser un singleton
public class Quinta {

	private Map<String,Espacio> espacios;
	private static EstacionDelAnio estacion;    //STATE
	private Set<Espacio> tiposEspacios;
	private String nombre;
	
	//Se crea con un mes cualquiera y luego los cambios de estado hacen que se acomode solo
	public Quinta(String nombre) {
		setNombre(nombre);
		setEspacios(new HashMap<String, Espacio>());
		setEstacion(Invierno.getSingletonInstance());
		setTiposEspacios(new HashSet<Espacio>());
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

	public static boolean puedePlantarseEnEstacion(Cultivo cultivo) {
		return estacion.puedePlantarseEnEstacion(cultivo);
	}

	public Map<String,Espacio> getEspacios() {
		return espacios;
	}

	public void setEspacios(Map<String,Espacio> espacios) {
		this.espacios = espacios;
	}

	public static EstacionDelAnio getEstacion() {
		return estacion;
	}

	public static void setEstacion(EstacionDelAnio estacion) {
		Quinta.estacion = estacion;
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

}
