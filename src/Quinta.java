import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Esto tambien debería ser un singleton
public class Quinta {
	

	private static List<Espacio> espacios = new ArrayList<>();
	private static EstacionDelAnio estacion = Invierno.getSingletonInstance();    //STATE
	private String nombre;
	private static Set<Cultivo> cultivosEnSistema = new HashSet<>();
	
	//Se crea con un mes cualquiera y luego los cambios de estado hacen que se acomode solo
	public Quinta(String nombre) {
		setNombre(nombre);
		setEstacion(calcularEstacion());
	}
	
  public static boolean puedePlantarseEnEstacion(Cultivo cultivo) {
		return estacion.puedePlantarseEnEstacion(cultivo);
	}
	
	public void agregarCultivoAEspacio(String nombre, Cultivo c) {
		boolean agregado = false;
		for(Espacio e: espacios) {
			if(e.getName() == nombre) {
				agregado = true;
				e.agregarCultivo(c);
			}
		}
		if(!agregado) System.out.println("Nombre del cultivo desconocido");
	}

	static void agregarEspacio(Espacio e) {
		espacios.add(e);
		System.err.println("ESPACIO "+e+" AGREGADO CON EXITO");
		System.out.println();
	}
  
	public void eliminarEspacio(Espacio e) {
		espacios.remove(e);
	}
	
	private static List<Espacio> getListaEspacios(){
		return new ArrayList<Espacio>(espacios);
	}

	public static void listarEspacios() {
		List<Espacio> espacios = getListaEspacios();
		if (espacios.size() > 0) {			
			for(Espacio e: espacios) {
				System.out.println(e);
			}
		}else {
			System.err.println("NO HAY ESPACIOS CARGADOS");
		}
		System.out.println();
	}
	
	private static void agregarCultivoSistema(String[] c) {
		cultivosEnSistema.add(new Cultivo(
											c[0], 
											Double.parseDouble(c[1]), 
											Double.parseDouble(c[2]), 
											Double.parseDouble(c[3]), 
											Double.parseDouble(c[4]), 
											c[5], 
											Double.parseDouble(c[6]), 
											Double.parseDouble(c[7]))
										);
  }
	
	private static void cargarCultivo() throws IOException {
		String strCurrent;
		String[] strSplit;
		BufferedReader buffer = new BufferedReader(new FileReader(new File("cultivo").getAbsolutePath()));
		while ((strCurrent = buffer.readLine()) != null) {
			strSplit = strCurrent.split(",");
			agregarCultivoSistema(strSplit);
		}
		buffer.close();
	}
	
	/* Getters and Setters */
    
  public Map<String,Espacio> getEspacios() {
		return espacios;
  }


	public Set<Espacio> getTiposEspacios() {
		return tiposEspacios;
	}

	public void setTiposEspacios(Set<Espacio> tiposEspacios) {
		this.tiposEspacios = tiposEspacios;
	}

	public static EstacionDelAnio getEstacion() {
		return estacion;
	}

	public static void setEstacion(EstacionDelAnio estacion) {
		Quinta.estacion = estacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static void main(String[] args) {
		try {
			cargarCultivo();
		} catch (IOException e) {
			System.out.println("Nombre erroneo del archivo");
			e.printStackTrace();
		}
		Menu.initApp();
	}
}

