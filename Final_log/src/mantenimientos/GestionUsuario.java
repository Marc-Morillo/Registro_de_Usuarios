package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Final_log.Conexion;
import bean.Usuario;

public class GestionUsuario
{
	public Usuario obtenerUsuario(Usuario usu)
	{
		Usuario usuario = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con = Conexion.conectar();
			String sql = "Select * from usuario where nombreUsuario = ? and contraseña = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getNombreUsuario());
			pst.setString(2, usu.getContraseña());
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error al obtener usuario");
		}
		return usuario;		
		
	}
}
