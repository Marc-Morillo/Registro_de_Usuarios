package Final_log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String controlador = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bd_itla";
	private static final String usuario = "root";
	private static final String clave = "YHwh1914";
	
	static
	{
		try
		{
			Class.forName(controlador);	
		} catch (ClassNotFoundException e)
		{
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
		
	}
	
	public static Connection conectar(){
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexion, ok!");
			}
			catch(SQLException e) {
				System.out.println("Error en la conexion");
				e.printStackTrace();
			}
		return conexion;
	}
}
