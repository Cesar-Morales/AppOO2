import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OtonioCultivoAptoTest {

	private EstacionDelAnio otonio;
	private Cultivo mayorResistencia, 
					igualResistencia, 
					menorResistencia;
	private Calendar epocaOtonio;
	private Supplier<Calendar> fixedSuplierOtonio;


	@Before
	public void setUp() {

		epocaOtonio = Calendar.getInstance();
		epocaOtonio.set(Calendar.MONTH, 4);
		fixedSuplierOtonio = () -> epocaOtonio;

		otonio = new Otonio(fixedSuplierOtonio);

		mayorResistencia = new Cultivo("Papa1", 2.6, 25.0, 49.0, 26.0, "Familia raiz1", 26.0, 25.0);
		igualResistencia = new Cultivo("Papa2", 7.2, 16.0, 48.0, 21.0, "Familia raiz2", 18.0, 26.0);
		menorResistencia = new Cultivo("Papa3", 4.5, 12.0, 47.0, 12.0, "Familia raiz3", 6.0, 27.0); 
	}

	@Test
	public void cultivoAptoTest() {
		assert(otonio.puedePlantarseEnEstacion(mayorResistencia));
		assert(otonio.puedePlantarseEnEstacion(igualResistencia));

		assertFalse(otonio.puedePlantarseEnEstacion(menorResistencia));
	}
	
	@After
    public void tearDown() {
        otonio = null;
		fixedSuplierOtonio = null;
		epocaOtonio = null;
        mayorResistencia = null;
		igualResistencia = null; 
		menorResistencia = null;
    }
}
