package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.Conexion;
import constructor.EmpleadoC;

public class GestionEmpleados {
	
	public EmpleadoC obtenerEmpleado(EmpleadoC emp) {
		EmpleadoC empl = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.conectar();
			String sql = "select*from tbl_emp where idEmp = ? and passEmp = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, emp.getIdEmp());
			ps.setInt(2, emp.getPassEmp());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				empl = new EmpleadoC(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			con.close();
		}catch(Exception e) {
			System.out.println("Error al obtener usuario");
		}
		
		return empl;
	}
}
