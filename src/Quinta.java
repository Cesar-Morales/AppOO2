import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	}
	
  public static boolean puedePlantarseEnEstacion(Cultivo cultivo) {
		return estacion.puedePlantarseEnEstacion(cultivo);
	}
	
	public boolean agregarCultivoAEspacio(String nombre, Cultivo c) {
		for(Espacio e: espacios) {
			if(e.getName() == nombre) {
				e.agregarCultivo(c);
				return true;
			}
		}
		return false;
	}

	static void agregarEspacio(Espacio e) {
		espacios.add(e);
		System.err.println("ESPACIO "+e+" AGREGADO CON EXITO");
		System.out.println();
	}
  
	public boolean eliminarEspacio(Espacio e) {
		return espacios.remove(e);
	}
	
	public static List<Espacio> getListaEspacios(){
		return espacios;
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

