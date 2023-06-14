package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conexion.Conexion;
import constructor.ProductoC;

public class ProductoCRUD {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insertar(ProductoC prod) {
		try {
			con = Conexion.conectar();
			String sql = "insert into tbl_prod (cveProd, dscrProd, provProd, catProd, sabProd, preProd, costprod) values (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, prod.getCveProd());
			ps.setString(2, prod.getDscrProd());
			ps.setInt(3, prod.getProvProd());
			ps.setInt(4, prod.getCatProd());
			ps.setInt(5, prod.getSabProd());
			ps.setFloat(6, prod.getPreProd());
			ps.setFloat(7, prod.getCostProd());
			
			int res = ps.executeUpdate();
			if(res > 0) {JOptionPane.showMessageDialog(null,"Resgistro exitoso");}
			else {JOptionPane.showMessageDialog(null, "Error al registrar");}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public ProductoC buscar(ProductoC prod) {
		ProductoC produ = null;
		try {
			con = Conexion.conectar();
			String sql = "select *from tbl_prod where cveProd = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, prod.getCveProd());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				produ = new ProductoC(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getFloat(7));
			}
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener proveedor", null, JOptionPane.ERROR_MESSAGE);
		}
		return produ;
	}
	
	public void modificar(ProductoC prod) {
		try {
			con = Conexion.conectar();
			String sql = "update tbl_prod set cveProd = ?, dscrProd = ?, provProd = ?, catProd = ?, sabProd = ?, preProd = ?, costProd = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, prod.getCveProd());
			ps.setString(2, prod.getDscrProd());
			ps.setInt(3, prod.getProvProd());
			ps.setInt(4, prod.getCatProd());
			ps.setInt(5, prod.getSabProd());
			ps.setFloat(6, prod.getPreProd());
			ps.setFloat(7,prod.getCostProd());
			
			int res = ps.executeUpdate();
			if(res > 0) {JOptionPane.showMessageDialog(null,"Actualización exitosa");}
			else {JOptionPane.showMessageDialog(null, "Error al actualizar");}
			con.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener proveedor", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void eliminar(int cveProd) {
		try {
			con = Conexion.conectar();
			String sql = "delte from tbl_prov where cveProd = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cveProd);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				JOptionPane.showMessageDialog(null,"Producto eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "Error al eliminar");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al elimnar producto", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void ConsultarProveedor(JComboBox<String> proveedor) {
		
		try {
			con = Conexion.conectar();
			String sql = "select idProv from tbl_prov";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				proveedor.addItem(rs.getString("idProv"));
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void ConsultarNomProv(String idProv, JTextField txtdscrProv) {
		try {
			con = Conexion.conectar();
			String sql = "select nomProv from tbl_prov where idProv = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, idProv);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				txtdscrProv.setText(rs.getString("nomProv"));
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void ConsultarCategoria(JComboBox<String> categoria) {
		try {
			con = Conexion.conectar();
			String sql = "select idCat from tbl_cat";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				categoria.addItem(rs.getString("idCat"));
			}
			con.close();
		}catch(Exception e){
			System.err.println(e);
		}
	}
	
	public void ConsultarNomCat(String idCat, JTextField txtdscrCat) {
		try {
			con = Conexion.conectar();
			String sql = "select dscrCat from tbl_cat where idCat = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, idCat);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				txtdscrCat.setText(rs.getString("dscrCat"));
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	
}
