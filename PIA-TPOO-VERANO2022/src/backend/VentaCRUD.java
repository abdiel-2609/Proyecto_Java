package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;

public class VentaCRUD {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public float precio(int cveProd) {
		float preProd = 0;
		try {
			con = Conexion.conectar();
			String sql = "select preProd from tbl_prod where cveProd = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cveProd);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				preProd = rs.getFloat("preProd");
			}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
		}
		return preProd;
	}
	
	public void insertar(int ordVta, int cveVta, int cantVtam, float impVta) {
		try {
			con = Conexion.conectar();
			String sql = "insert into tbl_dtlvta (ordVta, cveVta, cantVta, impVta) values (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ordVta);
			ps.setInt(2, cveVta);
			ps.setInt(3, cantVtam);
			ps.setFloat(4, impVta);
			
			int res = ps.executeUpdate();
			if(res > 0) {JOptionPane.showMessageDialog(null,"Resgistro exitoso");}
			else {JOptionPane.showMessageDialog(null, "Error al registrar");}
			con.close();
		}catch(Exception e) {
			System.err.println(e);
			JOptionPane.showMessageDialog(null, "Error al registrar");
		}
	}
}
