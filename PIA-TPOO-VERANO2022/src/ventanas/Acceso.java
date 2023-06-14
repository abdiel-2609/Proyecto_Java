package ventanas;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.GestionEmpleados;
import constructor.EmpleadoC;

@SuppressWarnings("serial")
public class Acceso extends JFrame{
	
	JTextField txt_cve, txt_pass;
	JButton btn_login;

	public static void main(String[] args) {
		Acceso acs = new Acceso();
		acs.iniciar();
	}
	
	protected void iniciar() {
		Acceso acs = new Acceso();
		acs.GUI_acceso();
		acs.setSize(700, 400);
		acs.setLocationRelativeTo(null);
		acs.setVisible(true);
		acs.setResizable(false);
	}

	protected void GUI_acceso() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Acceso");
		Container frame = this.getContentPane();
		
		frame.setLayout(null);
		
		JLabel lb_login = new JLabel("Inicio de Sesión");
		JLabel lb_cve = new JLabel("Clave:");
		JLabel lb_pass = new JLabel("Contraseña:");
		
		txt_cve = new JTextField(30);
		txt_pass = new JTextField(30);
		
		btn_login = new JButton("Entrar");
		
		lb_login.setBounds(230, 25, 400, 80);
		lb_cve.setBounds(200, 125, 150, 25);
		lb_pass.setBounds(200, 175, 150, 25);
		
		lb_login.setFont(new Font("Arial", Font.PLAIN, 35));
		lb_cve.setFont(new Font("Arial", Font.PLAIN, 18));
		lb_pass.setFont(new Font("Arial", Font.PLAIN, 18));
		
		lb_cve.setHorizontalAlignment(JLabel.CENTER);
		
		txt_cve.setBounds(330, 125, 150, 25);
		txt_pass.setBounds(330, 175, 150, 25);
		btn_login.setBounds(300, 225, 100, 25);
		
		frame.add(lb_login);
		frame.add(lb_cve);
		frame.add(txt_cve);
		frame.add(lb_pass);
		frame.add(txt_pass);
		frame.add(btn_login);
		
		btn_login.addActionListener(btnlogin);
	}
	
	ActionListener btnlogin = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ingresar();
		}
		
	};
	
	protected void ingresar() {
		int empl = Integer.parseInt(txt_cve.getText()), pass = Integer.parseInt(txt_pass.getText());
		GestionEmpleados GE = new GestionEmpleados();
		
		EmpleadoC empleado2 = new EmpleadoC();
		empleado2.setIdEmp(empl);
		empleado2.setPassEmp(pass);
		
		EmpleadoC emp = GE.obtenerEmpleado(empleado2);
		
		if(emp != null) {
			int priv = emp.getIdpuestoEmp();
			JOptionPane.showMessageDialog(null, "Bienvenido");
			Menu vm = new Menu();
			vm.iniciar(priv);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
			txt_cve.setText(null);
			txt_pass.setText(null);
		}
	}
}
