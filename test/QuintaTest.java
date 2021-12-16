import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuintaTest {
	
	
	private String nombreQuinta = "Mi Quinta";
	private String nombreEspacio = "Mi Espacio";
	private Quinta miQuinta;
	private TipoDeSuelo tipoSuelo;
	private Espacio espacio;
	private Cultivo papa, apio;
	
	@Before
	public void setUp() {
		miQuinta = new Quinta(nombreQuinta);
		tipoSuelo = new BlackSoil();
		espacio = new Espacio("Campo", tipoSuelo);
        papa = new Cultivo("Papa1", 2.6, 25.0, 49.0, 45.0, "Familia raiz1", 20.0, 25.0);
		apio = new Cultivo("Apio", 9.0, 12.0, 40.0, 20.0, "Familia Apio", 20.0, 19.0);
	}

	@Test
	public void agregarVerdurasAQuintas() {
		assertEquals(espacio.listaDeCultivos().size(), 0);
		assertFalse(miQuinta.agregarCultivoAEspacio("Campo asdasd", papa));
		assertTrue(miQuinta.agregarCultivoAEspacio(nombreEspacio, apio));
		assertEquals(espacio.listaDeCultivos().size(), 1);
		miQuinta.eliminarEspacio(espacio);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void manipulandoEspacios() {
		assertEquals(miQuinta.getListaEspacios().size(),0);
		miQuinta.agregarEspacio(espacio);
		assertEquals(miQuinta.getListaEspacios().size(), 1);
		assertTrue(miQuinta.eliminarEspacio(espacio));
		assertEquals(miQuinta.getListaEspacios().size(),0);
		miQuinta.eliminarEspacio(espacio);
		assertEquals(miQuinta.getListaEspacios().size(),0);
	}

	@Test
	public void listarEspacios() {
		System.out.println("lista "+espacio);
		assertEquals(miQuinta.getListaEspacios().size(),0);
		//miQuinta.agregarEspacio(espacio);
		//System.out.println(miQuinta.listarEspacios());
		//CON LA CLASE ESPACIO TERMINADA CONSULTAR SI ESPACIO QUE AGREGO ES EL MISMO
	}
	
	@After
    public void tearDown() {
		miQuinta = null;
		tipoSuelo = null;
		espacio = null;
		papa = null;
		apio = null;
    }
	
}
