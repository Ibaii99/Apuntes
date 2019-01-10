import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junits {

	@Test
	void test() {
		// Si no son iguales -> Buen test
		assertNotEquals("Dato que esperas", "El dato que es");
		
		// Si son iguales buen test
		assertEquals("Hola", "Hola");
		

		
	}

}
