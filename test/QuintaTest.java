import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QuintaTest {
	private static String nombre = "Mi Quinta";
	private static Quinta miQuinta;
	private static Espacio espacio;
	private static TipoDeSuelo tipoSuelo;
	
	@BeforeAll
	public static void setUp() {
		miQuinta = new Quinta(nombre);
		tipoSuelo = new BlackSoil();
		espacio = new Espacio("Campo", tipoSuelo);
		//probar creando quintas vacias
		//quintas llenas
		//distintas quintas para cada prueba sino se chocan los test
	}
	
	@Test
	public void constructorQuinta() {
		assertEquals(miQuinta.getEspacios().size(), 0);
		assertEquals(miQuinta.getNombre(), nombre);
		assertEquals(miQuinta.getTiposEspacios().size(), 0);
	}
	
	@Test
	public void manipulandoEspacios() {
		assertEquals(miQuinta.getTiposEspacios().size(),0);
		Quinta.agregarEspacio(espacio);
		assertEquals(miQuinta.getTiposEspacios().size(),1);
		miQuinta.eliminarEspacio(espacio);
		assertEquals(miQuinta.getTiposEspacios().size(),0);
		miQuinta.eliminarEspacio(espacio);
		assertEquals(miQuinta.getTiposEspacios().size(),0);
	}

	@Test
	public void listarEspacios() {
		assertEquals(Quinta.getListaEspacios().size(),0);
		//miQuinta.agregarEspacio(espacio);
		//System.out.println(miQuinta.listarEspacios());
		//CON LA CLASE ESPACIO TERMINADA CONSULTAR SI ESPACIO QUE AGREGO ES EL MISMO
	}
	
	@Test
	public void registrarEspacio() {
		//hacerlo cuando tenga espacio
	}
	
	@Test
	public void epocaActual() {
		//hacerlo cuando tenga estacion del año
	}

}
