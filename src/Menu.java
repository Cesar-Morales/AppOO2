import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Menu {

	private Quinta quinta;
	private Set<Cultivo> cultivosEnSistema = new HashSet<>();

	public Menu(Quinta quinta){
		this.quinta = quinta;
	}

	public void initApp() throws IOException{
		cargarCultivos();
		while(true) {			
			imprimirMenu();
			int opc = recibirOpcion();
			if(opc == 0) {
				System.err.println("Menu finalizado");
				break;
			}
			hacerTarea(opc);
		}
	}
	
	private void hacerTarea(int opc) {
		switch(opc) {
    	case 1:
			quinta.listarEspacios();
    		break;
	    case 2:
	    	agregarCultivoAEspacio();
	    	break;
	    default:
	    	System.err.println("OPCION INVALIDA");
	    	break;
		}
	}

	private void agregarCultivoAEspacio() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		Cultivo cultivo;
		
		System.out.println("|----------------------------------------|");
		System.out.println("| Ingrese el nombre del cultivo:         |");
		System.out.println("|----------------------------------------|");
		cultivosEnSistema.forEach(System.out::println);
		String nombreCultivo = teclado.next();
		try{
			cultivo = cultivosEnSistema.stream()
					.filter(c -> c.getName().equals(nombreCultivo))
					.findFirst().orElseThrow();
			System.out.println("|----------------------------------------|");
			System.out.println("| Ingrese el nombre del espacio:         |");
			System.out.println("|----------------------------------------|");
			String nombreEspacio = teclado.next();
			quinta.agregarCultivoAEspacio(nombreEspacio, cultivo);
		}
		catch (NoSuchElementException e){
			System.out.println();
		}
	}

	private int recibirOpcion() {
		int opc;
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);	
		try {			
			opc = Integer.parseInt(teclado.next());
		} catch (Exception e) {
			opc = 0;
		}
		return opc;
	}

	private void imprimirMenu() {
		System.out.println(" ----------------------------------------");
		System.out.println("| Framework para el control de Quintas:  |");
		System.out.println("|----------------------------------------|");
		System.out.println("| Ingrese una opcion:                    |");
		System.out.println("|----------------------------------------|");
		System.out.println("| (0) Salir                              |");
		System.out.println("| (1) Listar Espacios                    |");
		System.out.println("| (2) Agregar Cultivo a Espacio          |");
		System.out.println(" ----------------------------------------");
		System.out.println();
	}

	private void agregarCultivoSistema(String[] c) {
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
	
	private void cargarCultivos() throws IOException {
		String strCurrent;
		String[] strSplit;
		BufferedReader buffer = new BufferedReader(new FileReader(new File("cultivo").getAbsolutePath()));
		while ((strCurrent = buffer.readLine()) != null) {
			strSplit = strCurrent.split(",");
			agregarCultivoSistema(strSplit);
		}
		buffer.close();
	}
}
