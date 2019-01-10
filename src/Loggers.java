import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loggers {
	
	/*Inicializar un loger de forma externa a un metodo
	 private static Logger logger = Logger.getLogger( "Seguimiento sesiones" );
	
	static {
		try {
			logger.addHandler( new FileHandler( "errores-sesiones.xml", true ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 */
	private void repaso() throws SecurityException, IOException {
	// Inicializaci�n de logger
	Logger logger = Logger.getLogger( getClass().getName() );//myClass.class.getName() or the name you want
	
	// Sin la extensión a archivo no se puede guardar -- Deberia de ir con Try/Catch
	FileHandler extensionAArchivo =  new FileHandler( "errores-sesiones.xml", true );
	
	// Añadimos la extensión de archivo al logger para que se pueda guardar
	logger.addHandler(extensionAArchivo);
	
	String l = "Prueba de Logger con Java Funcional";
	/*
	Level.WARNING;	-> Warning Message
	Level.INFO;		-> Information message
	Level.SEVERE;	-> Heavy error
	Level.OFF;		-> Can be used to close logger
	Level.FINER;	-> Without much info/detais
	Level.FINEST;	-> With 
	*/
	logger.log(Level.INFO, "This is a log: ");
	
	logger.info("The info you want to log ");
}}
