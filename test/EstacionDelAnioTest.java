import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EstacionDelAnioTest {

	private static EstacionDelAnio invierno;
	
	@BeforeAll
	public static void setUp() {
		invierno = new Invierno();
		//seguir con todas
	}
	
	@Test
	void test() {
		assertEquals(invierno.getHumedad(),10);
	}

}
