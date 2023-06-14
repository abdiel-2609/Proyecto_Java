package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;
import constructor.CategoriaC;

public class CategoriaCRUD {
	
	public void insertar(int idCat, String dscrCat) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "insert into tbl_cat (idCat, dscrCat) values (?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idCat);
			ps.setString(2, dscrCat);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "Registro exitoso");
			}else {
				JOptionPane.showMessageDialog(null, "Error al cargar");
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void modiciar(int idCat, String dscrCat) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "update tbl_cat set dscrCat = ? where idEmp = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dscrCat);
			ps.setInt(2, idCat);
			
			int res = ps.executeUpdate();
			if(res > 0) {JOptionPane.showMessageDialog(null, "Actualización exitosa");}
			else {JOptionPane.showMessageDialog(null, "Error al actualizar)");}
			
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void eliminar(int idCat) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.conectar();
			String sql = "delete from tbl_cat where idCat = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idCat);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "Categoria eliminada");
			}else {
				JOptionPane.showMessageDialog(null, "Error al eliminar");
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public CategoriaC buscar(CategoriaC cat) {
		CategoriaC cate = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.conectar();
			String sql = "select * from tbl_cat where idCat = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cat.getIdCat());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cate = new CategoriaC(rs.getInt(1), rs.getString(2));
			}
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener categoria", null, JOptionPane.ERROR_MESSAGE);
		}
		
		
		return cate;
	}
}
