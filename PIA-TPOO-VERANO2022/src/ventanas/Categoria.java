package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.CategoriaCRUD;
import constructor.CategoriaC;

@SuppressWarnings("serial")
public class Categoria extends JFrame{

	JTextField txtidCat,txtdscrCat;
	JButton btnalta,btnact,btnsal,btngua,btncan,btneli,btnbus,btnmenu;
	int privi;
	/*public static void main(String[] args) {
		Categoria cat = new Categoria();
		cat.iniciar();
	}*/

	protected void iniciar(int priv) {
		Categoria cat = new Categoria();
		cat.GUI_categoria(priv);
		cat.setSize(650,300);
		cat.setLocationRelativeTo(null);
		cat.setVisible(true);
		cat.setResizable(false);
	}
	private void GUI_categoria(int priv) 
	{
		privi = priv;
		Container frame = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Categoria");
		//frame.setSize(650,300);
		
		frame.setLayout(null);
		
		JLabel lbidCat = new JLabel("Categoria ID: ");
		JLabel lbdscrCat = new JLabel("Descripcion: ");
		lbidCat.setBounds(80, 30, 120, 50);
		lbdscrCat.setBounds(80,65 , 120, 50);
		
		txtidCat = new JTextField();
		txtidCat.setBounds(170, 45, 70, 25);
		txtdscrCat = new JTextField();
		txtdscrCat.setBounds(170, 80, 250, 25);
		
		
		
		btnalta = new JButton("Alta");
		btnact = new JButton("Actualizar");
		btngua = new JButton("Guardar");
		btncan = new JButton("Cancelar");
		btneli = new JButton("Eliminar");
		btnsal = new JButton("Salir");
		btnmenu = new JButton("Menu");
		btnbus = new JButton("Buscar");
		
		
		btnalta.setBounds(80, 150, 95, 30);
		btnact.setBounds(80, 190, 95, 30);
		btngua.setBounds(190, 150, 95, 30);
		btneli.setBounds(190, 190, 95, 30);
		btncan.setBounds(300, 150, 95, 30);
		btnsal.setBounds(300, 190, 95, 30);
		btnmenu.setBounds(500, 150, 95, 60);
		btnbus.setBounds(500, 30, 95, 30);
		
		
		frame.add(lbidCat);
		frame.add(lbdscrCat);
		frame.add(txtidCat);
		frame.add(txtdscrCat);
		
		frame.add(btnalta);
		frame.add(btnact);
		frame.add(btngua);
		frame.add(btneli);
		frame.add(btncan);
		frame.add(btnsal);
		frame.add(btnmenu);
		frame.add(btnbus);
		
		btnalta.addActionListener(btn_alta);
		btnact.addActionListener(btn_act);
		btngua.addActionListener(btn_gua);
		btneli.addActionListener(btn_eli);
		btnbus.addActionListener(btn_bus);
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
	
	ActionListener btn_act = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int idCat = Integer.parseInt(txtidCat.getText());
			String dscrCat = txtdscrCat.getText();
			
			CategoriaCRUD ccrud = new CategoriaCRUD();
			ccrud.modiciar(idCat, dscrCat);
		}
	};
	
	ActionListener btn_gua = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Integer idCat = Integer.parseInt(txtidCat.getText());
			String dscrCat = txtdscrCat.getText();
			
			if(dscrCat.isEmpty() || idCat == null) {
				JOptionPane.showMessageDialog(null, "Algún campo está vacío");
			}else {
				CategoriaCRUD ccrud = new CategoriaCRUD();
				ccrud.insertar(idCat, dscrCat);
			}
		}
	};
	
	ActionListener btn_eli = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int idCat = Integer.parseInt(txtidCat.getText());
			
			CategoriaCRUD ccrud = new CategoriaCRUD();
			ccrud.eliminar(idCat);
			limpiarDatos();
		}
		
	};
	
	ActionListener btn_bus = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int idCat = Integer.parseInt(txtidCat.getText());
			CategoriaCRUD ccrud = new CategoriaCRUD();
			
			CategoriaC cate = new CategoriaC();
			cate.setIdCat(idCat);
			
			CategoriaC cat = ccrud.buscar(cate);
			if(cat != null) {
				txtidCat.setText(String.valueOf(cat.getIdCat()));
				txtdscrCat.setText(cat.getDscrCat());
			}
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
		txtidCat.setText(null);
		txtdscrCat.setText(null);;
	}
}
