package modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import controlador.Conexion;

public class UsuarioDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	UsuarioDTO usu;
	
	public boolean insertarusuario(UsuarioDTO us) {
		int x;
		boolean dat=false;
		try {
			usu=consultarusuario(us);
			if(usu==null) {
				ps=cnn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?)");
				ps.setInt(1, us.getDocumento());
				ps.setString(2, us.getNomusu());
				ps.setString(3, us.getClave());
				ps.setString(4, us.getRol());
				ps.setString(5, us.getEstado());
				x=ps.executeUpdate();
				if(x>0) {
					dat=true;
				}
				else {
					JOptionPane.showMessageDialog(null, "El usuario");
				}
			}			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar"+e);
		}
		return dat;
	}
	
	public UsuarioDTO consultarusuario(UsuarioDTO us) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuario WHERE documento=?");
			ps.setInt(1, us.getDocumento());
			rs=ps.executeQuery();
			if(rs.next()) {
				usu=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usu;
	}
	
	public int eliminar(UsuarioDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuario WHERE documento=?");
			ps.setInt(1, us.getDocumento());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	
	public boolean actualizar(UsuarioDTO us) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE usuario SET nomusu=?, clave=?, rol=?, estado=? WHERE documento=?");
			ps.setString(1, us.getNomusu());
			ps.setString(2, us.getClave());
			ps.setString(3, us.getRol());
			ps.setString(4, us.getEstado());
			ps.setInt(5, us.getDocumento());
			x=ps.executeUpdate();
			if(x>0) {
				dat=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return dat;
	}

}
