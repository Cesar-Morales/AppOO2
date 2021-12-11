import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimaveraCultivoAptoTest {

	private EstacionDelAnio primavera;
	private Cultivo mayorAlRango, 
					bordeSuperiorRango, 
					dentroDelRango, 
					bordeInferiorRango,
					menorAlRango;
	private Calendar epocaPrimavera;
	private Supplier<Calendar> fixedSuplierPrimavera;


	@Before
	public void setUp() {

		epocaPrimavera = Calendar.getInstance();
		epocaPrimavera.set(Calendar.MONTH, 11);
		fixedSuplierPrimavera = () -> epocaPrimavera;

		primavera = new Primavera(fixedSuplierPrimavera);

		mayorAlRango = new Cultivo("Papa1", 2.6, 25.0, 49.0, 15.2, "Familia raiz1", 20.0, 25.0);
		bordeSuperiorRango = new Cultivo("Papa2", 7.2, 16.0, 48.0, 6.0, "Familia raiz2", 20.1, 26.0);
		dentroDelRango = new Cultivo("Papa3", 4.5, 12.0, 47.0, 1.3, "Familia raiz3", 20.3, 27.0); 
		bordeInferiorRango = new Cultivo("Papa4", 7.5, 10.0, 46.0, 15.0, "Familia raiz4", 20.4, 17.0);
		menorAlRango = new Cultivo("Papa5", 3.5, 2.0, 45.0, 6.0, "Familia raiz5", 20.6, 17.0);
	}

	@Test
	public void cultivoAptoTest() {
		assert(primavera.puedePlantarseEnEstacion(bordeSuperiorRango));
		assert(primavera.puedePlantarseEnEstacion(dentroDelRango));
		assert(primavera.puedePlantarseEnEstacion(bordeInferiorRango));

		assertFalse(primavera.puedePlantarseEnEstacion(mayorAlRango));
		assertFalse(primavera.puedePlantarseEnEstacion(menorAlRango));
	}
	
	@After
    public void tearDown() {
        primavera = null;
		fixedSuplierPrimavera = null;
		epocaPrimavera = null;
        bordeSuperiorRango = null;
		dentroDelRango = null; 
		bordeInferiorRango = null;
		mayorAlRango = null;
		menorAlRango = null;
    }
}
