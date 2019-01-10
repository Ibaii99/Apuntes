import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Junits {
	
	
	/** Para hacer algo antes que nada, si tendriamos una BD, este sería el punto de iniciarla por ejemplo
	 *  O para realizar la conexion a ella, tiene que ser estático porque tiene que estar 'preparado' antes
	 *  de que el resto se ejecute.
	 */
	@AfterAll
	static void testLoPrimero() {
		//Aserts
	}
	
	/** Esto se ejecuta antes que los test, en el mismo ejemplo de la BD esto podría usarse para comprobar la 
	 *  Creación de tablas
	 */
	@After
	void testAntes() {
		//Assert
	}
	
	/** Puedes hacer tantos test como quieras, mejor muchos, asi si uno da error
	 *  Sabes cual es y tardas menos en saber porque, los metodos que uso se usan
	 *  En todos los test, sean after, before o suputamadre.
	 */
	@Test
	void test() {
		
		// Si son iguales buen test
		assertEquals("Hola", "Hola");
		// Si no es
		assertNotEquals("Dato que esperas", "El dato que es");
//--------------------------------------------------------------------------------		
		// Si es True la condicion de dentro (boolean) dará buen test
		assertTrue(true);
		// Si es False 
		assertFalse(false);
//--------------------------------------------------------------------------------		
		// Si es null lo de dentro dara buen test
		assertNull(null);
		// Si no es 
		assertNotNull("Buen test");
//--------------------------------------------------------------------------------		
		// Si los objetos son iguales será buen test
		// OJO QUE SEAN DE LA MISMA CLASE NO QUIERE 
		// DECIR QUE SEAN IGUALES
		Object o = new Object();
		assertSame(o, o);
		// Si no es
		Object e = new Object(); // Es otro objeto, de la misma clase, pero totalmente distinto, ya que no tienen la misma direccion de memoria por decirlo de alguna forma
		assertNotSame(o, e);
//--------------------------------------------------------------------------------
	}

	/** 
	 *  
	 */
	@Before
	void testDespues() {
		//Asserts
	}
	
	/** Para hacer despues de todo, si tendriamos una BD, este sería el punto de cerrarla por ejemplo
	 *  O para realizar la DESconexion a ella, tiene que ser estático porque tiene que estar 'preparado' antes
	 *  de que el resto se ejecute, para que pase lo que pase se cierre de esta forma.
	 */
	@BeforeAll
	static void testDespuesDeTodo() {
		// Asserts
	}
}
