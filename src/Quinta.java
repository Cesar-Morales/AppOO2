
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Quinta {
	
	private Map<String,Espacio> espacios;
	private static EstacionDelAnio estacion;    //STATE
	private static Set<Espacio> tiposEspacios = new HashSet<Espacio>();
	private String nombre;
	private static Set<Cultivo> cultivosEnSistema = new HashSet<>();
	
	public Quinta(String nombre) {
		setNombre(nombre);
		setEspacios(new HashMap<String, Espacio>());
		setEstacion(calcularEstacion());
	}
	
	private EstacionDelAnio calcularEstacion() {
		Date date = new Date();
		int mes = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
		switch(mes) {
	    	case 1,2,3:
		        return Verano.getSingletonInstance();
		    case 4,5,6:
		        return Otonio.getSingletonInstance();
		    case 7,8,9:
		        return Invierno.getSingletonInstance();
		    case 10,11,12:
		        return Primavera.getSingletonInstance();
		    default:
		    	return null;
		 }
	}
	
	static void agregarEspacio(Espacio e) {
		tiposEspacios.add(e);
		System.err.println("ESPACIO "+e+" AGREGADO CON EXITO");
		System.out.println();
	}
	
	public void eliminarEspacio(Espacio e) {
		tiposEspacios.remove(e);
	}
	
	private static List<Espacio> getListaEspacios(){
		return new ArrayList<Espacio>(tiposEspacios);
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

	public void setEspacios(Map<String,Espacio> espacios) {
		this.espacios = espacios;
	}

	public static EstacionDelAnio getEstacion() {
		return estacion;
	}

	public void setEstacion(EstacionDelAnio estacion) {
		Quinta.estacion = estacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* Fin Getters and Setters */

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

