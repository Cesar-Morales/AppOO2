import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstacionPuedePlantarseTest {

	private EstacionDelAnio invierno, 
							primavera, 
							verano, 
							otonio;
							
	private Cultivo pasaInviernoYVerano, 
					noPasaInviernoOVerano, 
					pasaPrimaveraYOtonio, 
					noPasaPrimaveraOOtonio,
					pasaTodasEstaciones,
					noPasaNingunaEstacion;

	private Calendar epocaInvierno, 
					 epocaPrimavera,
					 epocaVerano,
					 epocaOtonio;

	private Supplier<Calendar> fixedSuplierInvierno, 
							   fixedSuplierPrimavera,
							   fixedSuplierVerano,
							   fixedSuplierOtonio;

	@Before
	public void setUp() {	

		epocaInvierno = Calendar.getInstance();
		epocaPrimavera = Calendar.getInstance();
		epocaVerano = Calendar.getInstance();
		epocaOtonio = Calendar.getInstance();

		epocaVerano.set(Calendar.MONTH, 1);
		epocaOtonio.set(Calendar.MONTH, 4);
		epocaInvierno.set(Calendar.MONTH, 8);
		epocaPrimavera.set(Calendar.MONTH, 10);

		fixedSuplierInvierno = () -> epocaInvierno;
		fixedSuplierPrimavera = () -> epocaPrimavera;
		fixedSuplierVerano = () -> epocaVerano;
		fixedSuplierOtonio = () -> epocaOtonio;

		pasaInviernoYVerano = new Cultivo("Apio", 8.5, 6.0, 6.0, 24.0, "Familia Apio", 9.0, 18.0);
		noPasaInviernoOVerano = new Cultivo("Pepino", 7.5, 12.0, 32.0, 2.0, "Familia Pepino", 19.0, 20.0);

		pasaPrimaveraYOtonio = noPasaInviernoOVerano;
		noPasaPrimaveraOOtonio = pasaInviernoYVerano;

		pasaTodasEstaciones = new Cultivo("Apio", 7.5, 12.0, 40.0, 20.0, "Familia Apio", 20.0, 19.0);
		noPasaNingunaEstacion = new Cultivo("Apio", 7.5, 1.0, 40.0, 3.0, "Familia Apio", 1.0, 19.0);
	}

	@Test
	public void puedePlantarseInviernoTest() {
		invierno = new Invierno(fixedSuplierInvierno);
		testPassInviernoVerano(invierno);

		invierno = new Invierno(fixedSuplierPrimavera);
		testPassNextToInviernoVerano(invierno);
	}

	@Test
	public void puedePlantarsePrimaveraTest() {
		primavera = new Primavera(fixedSuplierPrimavera);
		testPassPrimaveraOtonio(primavera);

		primavera = new Primavera(fixedSuplierVerano);
		testPassNextToPrimaverOtonio(primavera);
	}

	@Test
	public void puedePlantarseVeranoTest() {
		verano = new Verano(fixedSuplierVerano);
		testPassInviernoVerano(verano);

		verano = new Verano(fixedSuplierOtonio);
		testPassNextToInviernoVerano(verano);
	}

	@Test
	public void puedePlantarseOtonioTest() {
		otonio = new Otonio(fixedSuplierOtonio);
		testPassPrimaveraOtonio(otonio);

		otonio = new Otonio(fixedSuplierInvierno);
		testPassNextToPrimaverOtonio(otonio);
	}

	private void testPassInviernoVerano(EstacionDelAnio estacionDelAnio){
		assert(estacionDelAnio.puedePlantarseEnEstacion(pasaInviernoYVerano));
		assertFalse(estacionDelAnio.puedePlantarseEnEstacion(noPasaInviernoOVerano));
		testTodasEstaciones(estacionDelAnio);
	}

	private void testPassPrimaveraOtonio(EstacionDelAnio estacionDelAnio){
		assert(estacionDelAnio.puedePlantarseEnEstacion(pasaPrimaveraYOtonio));
		assertFalse(estacionDelAnio.puedePlantarseEnEstacion(noPasaPrimaveraOOtonio));
		testTodasEstaciones(estacionDelAnio);
	}

	private void testTodasEstaciones(EstacionDelAnio estacionDelAnio){
		assert(estacionDelAnio.puedePlantarseEnEstacion(pasaTodasEstaciones));
		assertFalse(estacionDelAnio.puedePlantarseEnEstacion(noPasaNingunaEstacion));
	}

	private void testPassNextToInviernoVerano(EstacionDelAnio estacionDelAnio) {
		testPassPrimaveraOtonio(estacionDelAnio);
	}

	private void testPassNextToPrimaverOtonio(EstacionDelAnio estacionDelAnio) {
		testPassInviernoVerano(estacionDelAnio);
	}

	@After
    public void tearDown() {
        invierno = null;
		epocaInvierno = null;
		epocaPrimavera = null;
		fixedSuplierInvierno = null;
		fixedSuplierPrimavera = null;
        pasaPrimaveraYOtonio = null;
        noPasaPrimaveraOOtonio = null;
		pasaInviernoYVerano = null;
        noPasaInviernoOVerano = null;
    }
}
