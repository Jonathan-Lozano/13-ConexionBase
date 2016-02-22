import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public final class Conexion {

	private static final Conexion con = new Conexion();
	private Connection conect = null;

	/**
	 * Constructor privado de la clase
	 */
	private Conexion() {
		getConect();
	}

	/**
	 * Metodo privado que realiza la conexion
	 */
	private void conection() {
		try {
			String bd = "agenda";
			String user = "root";
			String pass = "";
			String server = "jdbc:mysql://localhost/" + bd;

			Class.forName("com.mysql.jdbc.Driver");
			conect = DriverManager.getConnection(server, user, pass);

			System.out.println("¡Conectado!");

		} catch (Exception e) {
			System.out.print("Error con la conexion.\nTipo de error: " + e);
		}
	}

	/**
	 * Metodo que optiene la conexion
	 * 
	 * @return la variable que mantiene la conexion
	 */
	public Connection getConect() {
		if (conect == null) {
			conection();
		}
		return conect;
	}

	/**
	 * 
	 * @return Instancia de la clase
	 */
	public static Conexion getCon() {
		return con;
	}

}