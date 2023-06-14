package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3344/pasteleria";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	static Connection conectar = null;
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el conector");
			e.printStackTrace();
		}
	}
	public static Connection conectar() {
		try {
			conectar = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch(SQLException e){
			System.out.println("Error de conexión");
			e.printStackTrace();
		}
		
		return conectar;
	}
}