import java.util.ArrayList;
import java.util.List;

//Esto tambien debería ser un singleton
public class Quinta {
	

	private List<Espacio> espacios = new ArrayList<>();
	private static EstacionDelAnio estacion = Invierno.getSingletonInstance();    //STATE
	private String nombre;
	
	//Se crea con un mes cualquiera y luego los cambios de estado hacen que se acomode solo
	public Quinta(String nombre) {
		setNombre(nombre);
	}
	
  	protected Quinta(String nombre, EstacionDelAnio estacion) {
		  this(nombre);
		  setEstacion(estacion);
	}

	public boolean puedePlantarseEnEstacion(Cultivo cultivo) {
		return estacion.puedePlantarseEnEstacion(cultivo);
	}
	
	public Boolean agregarCultivoAEspacio(String nombre, Cultivo cultivo) {
		boolean agregado = false;
		for(Espacio e: espacios) {
			if(e.getName() == nombre) {
				if(puedePlantarseEnEstacion(cultivo)){
					agregado = e.agregarCultivo(cultivo);	
				}
			}
		}
		return agregado;
	}

	public void agregarEspacio(Espacio e) {
		espacios.add(e);
	}
	
	private List<Espacio> getListaEspacios(){
		return espacios;
	}

	public void listarEspacios() {
		List<Espacio> espacios = getListaEspacios();
		if (espacios.size() > 0) {			
			for(Espacio e: espacios) {
				System.out.println(e);
			}
		}else {
			System.out.println("NO HAY ESPACIOS CARGADOS");
		}
	}

	protected static void setEstacion(EstacionDelAnio estacion) {
		Quinta.estacion = estacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

