import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuintaTest {
	private String nombre = "Mi Quinta";
	private Quinta miQuinta;
	private Espacio espacio;
	private TipoDeSuelo tipoSuelo;
	private Calendar epocaOtonio;
	private Supplier<Calendar> fixedSuplierOtonio;
	private Cultivo sePuedePlantar, noSePuedePlantar;
	private EstacionDelAnio otonio;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;
	
	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));

		epocaOtonio = Calendar.getInstance();
		epocaOtonio.set(Calendar.MONTH, 4);
		fixedSuplierOtonio = () -> epocaOtonio;

		sePuedePlantar = new Cultivo("Papa", 7.5, 12.0, 32.0, 2.0, "Familia Pepino", 19.0, 20.0);
		noSePuedePlantar = new Cultivo("Apio", 8.5, 6.0, 6.0, 24.0, "Familia Apio", 9.0, 18.0);

		otonio = new Otonio(fixedSuplierOtonio);
		
		tipoSuelo = new Roots();
		espacio = new Espacio("Campo", tipoSuelo);
		miQuinta = new Quinta(nombre, otonio);
	}
	
	@Test
	public void agregarCultivoAEspacioInexistenteTest() {
		assertFalse(miQuinta.agregarCultivoAEspacio("Campo", sePuedePlantar));
	}

	@Test
	public void agregarCultivoAEspacioExistenteTest() {
		miQuinta.agregarEspacio(espacio);
		assertTrue(miQuinta.agregarCultivoAEspacio("Campo", sePuedePlantar));
		assertFalse(miQuinta.agregarCultivoAEspacio("Campo", noSePuedePlantar));
	}

	@Test
	public void listarEspaciosVacioTest() {
		miQuinta.listarEspacios();
		assertEquals("NO HAY ESPACIOS CARGADOS\n", outContent.toString());
	}

	@Test
	public void listarEspaciosTest() {
		miQuinta.agregarEspacio(espacio);
		miQuinta.agregarCultivoAEspacio("Campo", sePuedePlantar);
		miQuinta.listarEspacios();
		assertEquals("Espacio [name=Campo, cultivos=[name=Papa]]\n", outContent.toString());
	}
	
	@After
	public void tearDown() {
		miQuinta = null;
		System.setOut(originalOut);
	}

}
