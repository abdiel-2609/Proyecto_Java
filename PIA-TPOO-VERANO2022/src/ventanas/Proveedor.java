package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.ProveedorCRUD;
import constructor.ProveedorC;

@SuppressWarnings("serial")
public class Proveedor extends JFrame{
	int privi;
	JTextField txtidProv,txtnomProv,txtcontProv,txttelProv,txtemailProv,txtrfcProv;
	JButton btnalta,btnact,btngua,btneli,btncan,btnsal,btnmenu,btnbus;

	/*public static void main(String[] args) {
		Proveedor prov = new Proveedor();
		prov.iniciar();
	}*/

	protected void iniciar(int priv) {
		Proveedor prov = new Proveedor();
		prov.GUI_proveedor(priv);
		prov.setSize(700,500);
		prov.setLocationRelativeTo(null);
		prov.setVisible(true);
	}
	private void GUI_proveedor(int priv) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Proovedor");
		Container frame = this.getContentPane();
		
		
		frame.setLayout(null);
		
		JLabel lbidProv = new JLabel("Proveedor ID: ");
		JLabel lbnomProv = new JLabel("Proveedor: ");
		JLabel lbcontProv = new JLabel("Contacto: ");
		JLabel lbtelProv = new JLabel("Telefono: ");
		JLabel lbemailProv = new JLabel("Mail: ");
		JLabel lbrfcProv = new JLabel("RFC: ");
		lbidProv.setBounds(80,30,120,50);
		lbnomProv.setBounds(95,65,120,50);
		lbcontProv.setBounds(103,100,120,50);
		lbtelProv.setBounds(103,135,120,50);
		lbemailProv.setBounds(129,175,120,50);
		lbrfcProv.setBounds(128,210,120,50);
		
		txtidProv = new JTextField();
		txtidProv.setBounds(170,43,70,20);
		txtnomProv = new JTextField();
		txtnomProv.setBounds(170,80,250,20);
		txtcontProv= new JTextField();
		txtcontProv.setBounds(170,114,250,20);
		txttelProv= new JTextField();
		txttelProv.setBounds(170,149,125,20);
		txtemailProv= new JTextField();
		txtemailProv.setBounds(170,189,125,20);
		txtrfcProv= new JTextField();
		txtrfcProv.setBounds(170,224,125,20);
		

		btnalta = new JButton("Alta");
		btnact = new JButton("Actualizar");
		btngua = new JButton("Guardar");
		btncan = new JButton("Cancelar");
		btneli = new JButton("Eliminar");
		btnsal = new JButton("Salir");
		btnmenu = new JButton("Menu");
		btnbus = new JButton("Buscar");
		
		
		

		btnalta.setBounds(80,350,95,30);
		btnact.setBounds(80,390,95,30);
		btngua.setBounds(190,350,95,30);
		btneli.setBounds(190,390,95,30);
		btncan.setBounds(300,350,95,30);
		btnsal.setBounds(300,390,95,30);
		btnmenu.setBounds(500,350,95,50);
		btnbus.setBounds(500,30,95,30);
		
		
		frame.add(lbidProv);
		frame.add(lbnomProv);
		frame.add(lbcontProv);
		frame.add(lbtelProv);
		frame.add(lbemailProv);
		frame.add(lbrfcProv);
		
		frame.add(txtidProv);
		frame.add(txtnomProv);
		frame.add(txtcontProv);
		frame.add(txttelProv);
		frame.add(txtemailProv);
		frame.add(txtrfcProv);
		
		frame.add(btnalta);
		frame.add(btnact);
		frame.add(btngua);
		frame.add(btneli);
		frame.add(btncan);
		frame.add(btnsal);
		frame.add(btnmenu);
		frame.add(btnbus);
		
		btngua.addActionListener(btn_gua);
		btnalta.addActionListener(btn_alta);
		btnact.addActionListener(btn_act);
		btnbus.addActionListener(btn_bus);
		btnsal.addActionListener(btn_sal);
		btneli.addActionListener(btn_eli);
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
			int idProv = Integer.parseInt(txtidProv.getText());
			String nomProv = txtnomProv.getText(), contacProv = txtcontProv.getText(), telProv = txttelProv.getText(), emailProv = txtemailProv.getText(), rfcProv = txtrfcProv.getText();
			
			if(nomProv.isEmpty() || contacProv.isEmpty() || telProv.isEmpty() || emailProv.isEmpty() || rfcProv.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Algún campo está vacío");
			}else {
				ProveedorCRUD pcrud = new ProveedorCRUD();
				pcrud.insertar(idProv, nomProv, contacProv, telProv, emailProv, rfcProv);
				limpiarDatos();
			}
		}
	};
	
	ActionListener btn_bus = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int idProv = Integer.parseInt(txtidProv.getText());
			ProveedorCRUD pcrud = new ProveedorCRUD();
			
			ProveedorC prov = new ProveedorC();
			prov.setIdProv(idProv);
			
			ProveedorC prove = pcrud.buscar(prov);
			if(prove != null) {
				txtidProv.setText(String.valueOf(prove.getIdProv()));
				txtnomProv.setText(prove.getNomProv());
				txtcontProv.setText(prove.getContacProv());
				txttelProv.setText(prove.getTelProv());
				txtemailProv.setText(prove.getEmailProv());
				txtrfcProv.setText(prove.getRfcProv());
			}
		}
	};
	
	ActionListener btn_act = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int idProv = Integer.parseInt(txtidProv.getText());
			String nomProv = txtnomProv.getText(), contacProv = txtcontProv.getText(), telProv = txttelProv.getText(), emailProv = txtemailProv.getText(), rfcProv = txtrfcProv.getText();
			
			if(nomProv.isEmpty() || contacProv.isEmpty() || telProv.isEmpty() || emailProv.isEmpty() || rfcProv.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Algún campo está vacío");
			}else {
				ProveedorCRUD pcrud = new ProveedorCRUD();
				
				ProveedorC prov = new ProveedorC();
				prov.setIdProv(idProv);
				prov.setNomProv(nomProv);
				prov.setContacProv(contacProv);
				prov.setTelProv(telProv);
				prov.setEmailProv(emailProv);
				prov.setRfcProv(rfcProv);
				
				pcrud.buscar(prov);
				//pcrud.modificar(idProv, nomProv, contacProv, telProv, emailProv, rfcProv);
			}
		}
	};
	
	ActionListener btn_eli = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(txtidProv.getText());
			ProveedorCRUD pcrud = new ProveedorCRUD();
			pcrud.eliminar(id);
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
		txtidProv.setText(null);
		txtnomProv.setText(null);
		txtcontProv.setText(null);
		txttelProv.setText(null);
		txtemailProv.setText(null);
		txtrfcProv.setText(null);
	}
}
