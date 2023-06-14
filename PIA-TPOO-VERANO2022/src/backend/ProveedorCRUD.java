package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;
import constructor.ProveedorC;

public class ProveedorCRUD {
	
	public void insertar(int idProv, String nomProv, String contacProv, String telProv, String emailProv, String rfcProv) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "insert into tbl_prov (idProv, nomProv, contacProv, telProv, emailProv, rfcProv) values (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idProv);
			ps.setString(2, nomProv);
			ps.setString(3, contacProv);
			ps.setString(4, telProv);
			ps.setString(5, emailProv);
			ps.setString(6, rfcProv);
			
			int res = ps.executeUpdate();
			if(res > 0) {JOptionPane.showMessageDialog(null,"Resgistro exitoso");}
			else {JOptionPane.showMessageDialog(null, "Error al registrar");}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public ProveedorC buscar(ProveedorC prov) {
		ProveedorC prove = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.conectar();
			String sql = "select * from tbl_prov where idProv = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, prov.getIdProv());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prove = new ProveedorC(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
			}
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener proveedor", null, JOptionPane.ERROR_MESSAGE);
		}
		
		return prove;
	}
	
	public void modificar(ProveedorC prov) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "update tbl_prov set nomProv = ?, contacProv = ?, telProv = ?, email = ?, rfcProv = ? where idProv = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, prov.getNomProv());
			ps.setString(2, prov.getContacProv());
			ps.setString(3, prov.getTelProv());
			ps.setString(4, prov.getEmailProv());
			ps.setString(5, prov.getRfcProv());
			ps.setInt(6, prov.getIdProv());
			
			int res = ps.executeUpdate();
			if(res > 0) {JOptionPane.showMessageDialog(null,"Actualización exitosa");}
			else {JOptionPane.showMessageDialog(null, "Error al actualizar");}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	public void eliminar(int idProv) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "delete from tbl_prov where idProv = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idProv);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null,"Empleado eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "Error al eliminar");
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
}
