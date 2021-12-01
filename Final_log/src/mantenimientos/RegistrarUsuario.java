package mantenimientos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Final_log.Conexion;
import bean.Usuario;
import Final_log.Conexion;

public class RegistrarUsuario {
	
	public int registrar(Usuario usuario)
	{
		int rs = 0;
		
		String sql = "insert into usuario values(?, ?, ?, ?, ?, ?, ?, ?);";
		try(PreparedStatement ps = Conexion.conectar().prepareStatement(sql))
		{
			ps.setString(1, usuario.getID());
			ps.setString(2, usuario.getNombreUsuario());
			ps.setString(3, usuario.getNombre());
			ps.setString(4, usuario.getApellido());
			ps.setString(5, usuario.getTelefono());
			ps.setString(6, usuario.getCorreo());
			ps.setString(7, usuario.getContraseña());
			ps.setString(8, usuario.getConfirmarcontraseña());
			
			rs = ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
}
