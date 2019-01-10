import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;

public class BD {
	
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	public void init() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		String nombre = "El nombre de la BD";
		con = DriverManager.getConnection("jdbc:sqlite:" + nombre + ".db");
		
	}

	public void close() throws SQLException {
		if (con != null)
			con.close();
	}
	
	public void create() {
		String comando = "";
		try {
			init();
			// Se inicializa la conexión con el archivo
			System.out.println("inicio");
			try {
				st = con.createStatement(); //	Se crea una declaración
				comando = "CREATE TABLE ejemploTabla( 'id' INTEGER  AUTOINCREMENT,'Col1' INTEGER DEFAULT 0, 'Col2' TEXT NOT NULL);";
				
				st.executeUpdate(comando); // Se ejecuta el comando
				// Execute Update -> insert/update/delete data at the database
				
			} catch (SQLException i) {	// Si la tabla ya existe o hay algún problema salta a aquí, conviene poner logs para verlo más claro
				i.printStackTrace();} 
			close();
			
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
	
	public void insert(String[] datos) {

		try {
			init();
			// Se inicializa la conexión al archivo
			
			st = con.createStatement();  // Se crea la declaración
			String comando = "INSERT INTO ejemploTabla VALUES ("+datos[0]+", '"+datos[1]+"');"; 
			
			st.executeUpdate(comando);	// Se ejecuta el comando
			// Execute Update -> insert/update/delete data at the database
			
			close();
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();	}
	}

	public void update(String[] datos) {
		try {
			init();
			// Se inicializa la conexión con el archivo
			st = con.createStatement();
			String comando = "UPDATE ejemploTabla SET 'Col1'=" + datos[0] + " WHERE Col2='" + datos[1] + "'; "; //recordar los espacios de los comandos, sin espacios ERROR
			// Una vez escrito el comando lo ejecutamos recordando que 
			
			st.executeUpdate(comando); // Se ejecuta el comando
			// Execute Update -> insert/update/delete data at the database
			close();
		}catch(Exception i) {
			
		} 
	}

	public void select (String[] datos) {
		
		try {
			init();
			st = con.createStatement(); //	Se crea una declaración
			
			String comando = "SELECT * FROM ejemploTabla WHERE Col2='"+ datos[1] +"' ;";
			
			rs = st.executeQuery(comando); // Se ejecuta el comando y se guarda el resultado que toque en el rs
			// Execute Query -> execute statements that returns a result set by fetching some data from the database SELECT
			
			while(rs.next()) { // Segun la consulta pueden haber varios resultados, para analizarlos todos uso este bucle
				// Los convierto a enteros por si en algun momento se necesita con el formato de origen
				
				int col1 = Integer.parseInt(rs.getString("Col1"));  // Obtengo la columna 'Col1' del select
				int id = Integer.parseInt(rs.getString("id"));		// Obtengo el 'id' del select
				
				// Imprimo los elementos por hacer algo
				System.out.println("Elemento con la 'Col2' igual a la indicada: id-> "+ id +" Col1-> "+ col1);
			}
			
			close();
			
		} catch (Exception ex) {ex.printStackTrace();}
	}

	public void delete(String[] datos) {
		try {
			init();
			// Se inicializa la conexión con el archivo
			
			st = con.createStatement(); //	Se crea una declaración
			
			String query = "DELETE FROM ejemploTabla WHERE (Col1 = '"+ datos[0] +"' AND Col2="+ datos[1] +");";
	
			st.executeUpdate(query); // Se ejecuta el comando
			// Execute Update -> insert/update/delete data at the database
			
			close();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	
	}


}
