package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.EmpleadosCRUD;
import constructor.EmpleadoC;


@SuppressWarnings("serial")
public class Empleado extends JFrame{

	JTextField  txtidEmp,txtnomEmp,txttelEmp,txtmailEmp,txtpassEmp;
	JButton btnalta,btnact,btnsal,btngua,btncan,btneli,btnbus,btnmenu;
	JComboBox<String>cbxpuest,cbxgen;
	int privi;
	/*public static void main(String[] args) {
		Empleado emp = new Empleado();
		emp.iniciar();
	}*/
	
	protected void iniciar(int priv) {
		Empleado emp = new Empleado();
		emp.GUI_empleado();
		emp.setSize(650,500);
		emp.setLocationRelativeTo(null);
		emp.setVisible(true);
		emp.setResizable(false);
		privi = priv;
	}
	
	private void GUI_empleado() 
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//JFrame frame = new JFrame("Empleado");
		this.setTitle("Empleado");
		Container frame = this.getContentPane();
		
		frame.setLayout(null);
		
		
		JLabel lbidEmp = new JLabel("Empleado ID: ");
		JLabel lbnomEmp = new JLabel("Nombre: ");
		JLabel lbidpuesEmp = new JLabel("Puesto: ");
		JLabel lbtelEmp = new JLabel("Telefono: ");
		JLabel lbmailEmp = new JLabel("Mail: ");
		JLabel lbgenEmp = new JLabel("Genero: ");
		JLabel lbpassEmp = new JLabel("Contraseña: ");
		
		lbidEmp.setBounds(80, 30, 120, 50);
		lbnomEmp.setBounds(103,65 , 120, 50);
		lbtelEmp.setBounds(98, 100, 120, 50);
		lbmailEmp.setBounds(125,135 , 120, 50);
		lbidpuesEmp.setBounds(105, 170, 120, 50);
		lbgenEmp.setBounds(105,205 , 120, 50);
		lbpassEmp.setBounds(98, 247, 120, 50);
		
		
		txtidEmp = new JTextField();
		txtidEmp.setBounds(185, 45, 70, 25);
		txtnomEmp = new JTextField();
		txtnomEmp.setBounds(185, 80, 250, 25);
		txttelEmp = new JTextField();
		txttelEmp.setBounds(185, 110, 250, 25);
		txtmailEmp = new JTextField();
		txtmailEmp.setBounds(185, 143, 250, 25);
		txtpassEmp = new JTextField();
		txtpassEmp.setBounds(185, 260, 140, 25);
		
		cbxpuest = new JComboBox<String>();
		cbxpuest.setBounds(185, 180, 250, 25);
		cbxpuest.addItem("Seleccione");
		cbxpuest.addItem("Gerente");
		cbxpuest.addItem("Comprador");
		cbxpuest.addItem("Vendedor");
		//cbxpuest.addItem("Repartidor");
		cbxgen = new JComboBox<String>();
		cbxgen.setBounds(185, 220, 250, 25);
		cbxgen.addItem("Seleccione");
		cbxgen.addItem("Masculino");
		cbxgen.addItem("Femenino");
		
		btnalta = new JButton("Alta");
		btnact = new JButton("Actualizar");
		btngua = new JButton("Guardar");
		btncan = new JButton("Cancelar");
		btneli = new JButton("Eliminar");
		btnsal = new JButton("Salir");
		btnmenu = new JButton("Menu");
		btnbus = new JButton("Buscar");
		
		
		btnalta.setBounds(80, 320, 95, 30);
		btnact.setBounds(80, 360,95, 30);
		btngua.setBounds(190, 320, 95, 30);
		btneli.setBounds(190, 360, 95, 30);
		btncan.setBounds(300, 320, 95, 30);
		btnsal.setBounds(300, 360, 95, 30);
		btnmenu.setBounds(500,320, 95, 60);
		btnbus.setBounds(500,30, 95, 30);
		
		frame.add(lbidEmp);
		frame.add(lbnomEmp);
		frame.add(lbidpuesEmp);
		frame.add(lbtelEmp);
		frame.add(lbmailEmp);
		frame.add(lbgenEmp);
		frame.add(lbpassEmp);
		
		frame.add(txtidEmp);
		frame.add(txtnomEmp);
		frame.add(txttelEmp);
		frame.add(txtmailEmp);
		frame.add(txtpassEmp);
		
		
		frame.add(cbxpuest);
		frame.add(cbxgen);
	
		
		frame.add(btnalta);
		frame.add(btnact);
		frame.add(btngua);
		frame.add(btneli);
		frame.add(btncan);
		frame.add(btnsal);
		frame.add(btnmenu);
		frame.add(btnbus);
		
		btnalta.addActionListener(btn_alta);
		btngua.addActionListener(btn_gua);
		btnbus.addActionListener(btn_bus);
		btnact.addActionListener(btn_act);
		btneli.addActionListener(btn_eli);
		btnsal.addActionListener(btn_sal);
		btnmenu.addActionListener(btn_menu);
		
	}
	
	ActionListener btn_menu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuAdmin ma = new MenuAdmin();
			ma.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btn_alta = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			limpiarDatos();
		}
	};
	
	ActionListener btn_gua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre = txtnomEmp.getText(), telefono = txttelEmp.getText(), email = txtmailEmp.getText(), genero = cbxgen.getSelectedItem().toString(), pst = cbxpuest.getSelectedItem().toString();
			int puesto = 0, password = Integer.parseInt(txtpassEmp.getText());
			
			if(nombre.isEmpty() || telefono.isEmpty() || email.isEmpty() || genero.isEmpty() || pst.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Algún campo está vacío");
			}else {
				EmpleadosCRUD ecrud = new EmpleadosCRUD();
				if(pst == "Gerente") {puesto = 1;}
				else if(pst == "Comprador") {puesto = 2;}
				else if(pst == "Vendedor") {puesto = 3;}
				
				ecrud.insertar(nombre, puesto, telefono, email, genero, password);
				limpiarDatos();
			}
		}
	};
	
	ActionListener btn_act = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nombre = txtnomEmp.getText(), telefono = txttelEmp.getText(), email = txtmailEmp.getText(), genero = cbxgen.getSelectedItem().toString(), pst = cbxpuest.getSelectedItem().toString();
			int puesto = 0, password = Integer.parseInt(txtpassEmp.getText()), id = Integer.parseInt(txtidEmp.getText());
				
			EmpleadosCRUD ecrud = new EmpleadosCRUD();
			if(pst == "Gerente") {puesto = 1;}
			else if(pst == "Comprador") {puesto = 2;}
			else if(pst == "Vendedor") {puesto = 3;}
				
			ecrud.modificar(id, nombre, puesto, telefono, email, genero, password);
			//limpiarDatos();
		}
	};
	
	ActionListener btn_bus = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int idEmp = Integer.parseInt(txtidEmp.getText());
			EmpleadosCRUD ecrud = new EmpleadosCRUD();
			
			EmpleadoC emp = new EmpleadoC();
			emp.setIdEmp(idEmp);
			
			EmpleadoC empl = ecrud.buscar(emp);
			if(empl != null) {
				txtidEmp.setText(String.valueOf(empl.getIdEmp()));
				txtnomEmp.setText(empl.getNomEmp());
				txttelEmp.setText(empl.getTelEmp());
				txtmailEmp.setText(empl.getEmailEmp());
				cbxpuest.setSelectedIndex(empl.getIdpuestoEmp());
				if(empl.getGenEmp() == "Masculino") {cbxgen.setSelectedIndex(1);}
				else if(empl.getGenEmp() == "Femenino") {cbxgen.setSelectedIndex(2);}
			}
		}
	};
	
	ActionListener btn_eli = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(txtidEmp.getText());
			
			EmpleadosCRUD ecrud = new EmpleadosCRUD();
			ecrud.eliminar(id);
			limpiarDatos();
		}
	};
	
	ActionListener btn_sal = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	};
	
	private void salir() {
		this.dispose();
	}
	private void limpiarDatos() {
		txtidEmp.setText(null);
		txtnomEmp.setText(null);
		txttelEmp.setText(null);
		txtmailEmp.setText(null);
		txtpassEmp.setText(null);
		cbxpuest.setSelectedIndex(0);
		cbxgen.setSelectedIndex(0);
	}
}