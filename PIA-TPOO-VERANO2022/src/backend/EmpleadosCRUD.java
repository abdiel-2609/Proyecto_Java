package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;
import constructor.EmpleadoC;

public class EmpleadosCRUD {
	
	
	public void insertar(String nomEmp, int idpuestoEmp, String telEmp, String emailEmp, String genEmp, int passEmp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "insert into tbl_emp (nomEmp, idpuestoEmp, telEmp, emailEmp, genEmp, passEmp) values (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, nomEmp);
			ps.setInt(2, idpuestoEmp);
			ps.setString(3, telEmp);
			ps.setString(4, emailEmp);
			ps.setString(5, genEmp);
			ps.setInt(6, passEmp);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null,"Resgistro exitoso");
			}else {
				JOptionPane.showMessageDialog(null, "Error al registrar");
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public EmpleadoC buscar(EmpleadoC emp) {
		EmpleadoC empl = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.conectar();
			String sql = "select*from tbl_emp where idEmp = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, emp.getIdEmp());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				empl = new EmpleadoC(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener empleado", null, JOptionPane.ERROR_MESSAGE);
		}
		
		return empl;
		
	}
	
	public void modificar(int idEmp, String nomEmp, int idpuestoEmp, String telEmp, String emailEmp, String genEmp, int passEmp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "update tbl_emp set nomEmp = ?, idpuestoEmp = ?, telEmp = ?, emailEmp = ?, genEmp = ?, passEmp = ? where idEmp = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, nomEmp);
			ps.setInt(2, idpuestoEmp);
			ps.setString(3, telEmp);
			ps.setString(4, emailEmp);
			ps.setString(5, genEmp);
			ps.setInt(6, passEmp);
			ps.setInt(7, idEmp);
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null,"Actualización exitosa");
			}else {
				JOptionPane.showMessageDialog(null, "Error al registrar");
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void eliminar(int idEmp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "delete from tbl_emp where idEmp = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idEmp);
			
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
