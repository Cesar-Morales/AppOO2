import java.util.Scanner;

public class Menu {

	public static void initApp() {
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
	
	private static void hacerTarea(int opc) {
		switch(opc) {
    	case 1:
    		Quinta.listarEspacios();
    		break;
	    case 2:
	    	agregarEspacio();
	    	break;
	    default:
	    	System.err.println("OPCION INVALIDA");
	    	break;
		}
	}

	private static void agregarEspacio() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		Espacio e;
		System.out.println("|----------------------------------------|");
		System.out.println("| Ingrese el nombre de espacio:          |");
		System.out.println("|----------------------------------------|");
		String nombre = teclado.next();
		System.out.println("|----------------------------------------|");
		System.out.println("| Ingrese el tipo de suelo :             |");
		System.out.println("| (1) Roots                              |");
		System.out.println("| (2) Black Soil                         |");
		System.out.println("|----------------------------------------|");
		Integer num = Integer.parseInt(teclado.next());
		//ESTO HAY QUE CAMBIAR POR CASE Y VER COMO LEVANTAR LOS TIPOS DE SUELO PARA QUE LO MUESTRE EL PRINT EN FORMA DINAMICA
		//TAMBIEN HAY QUE CHEQUEAR QUE LO QUE INGRESE SEA CORRECTO (CON EL MISMO CASE)
		if(num == 1) {
			e = new Espacio(nombre, new Roots());
		} else {
			e = new Espacio(nombre, new BlackSoil());
		}
		Quinta.agregarEspacio(e);
	}

	private static int recibirOpcion() {
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

	private static void imprimirMenu() {
		System.out.println(" ----------------------------------------");
		System.out.println("| Framework para el control de Quintas:  |");
		System.out.println("|----------------------------------------|");
		System.out.println("| Ingrese una opcion:                    |");
		System.out.println("|----------------------------------------|");
		System.out.println("| (0) Salir                              |");
		System.out.println("| (1) Listar Espacios                    |");
		System.out.println("| (2) Agregar Espacio                    |");
		System.out.println(" ----------------------------------------");
		System.out.println();
	}
}
