package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import backend.ProductoCRUD;
import constructor.ProductoC;

@SuppressWarnings("serial")
public class Producto extends JFrame{
	
	JTextField txtidProd,txtdscrProd,txtpreProd,txtcostProd,txtdscrProv,txtdscrCat;
	JButton btnalta,btnact,btngua,btneli,btnsal,btnmen,btnbus,btncan;
	JComboBox<String>cbxprov,cbxcat;
	int privi;
	/*public static void main(String[] args) {
		Producto pd = new Producto();
		pd.iniciar();
	}*/

	protected void iniciar(int priv) {
		Producto pd = new Producto();
		pd.GUI_producto();
		pd.setSize(630,500);
		pd.setLocationRelativeTo(null);
		pd.setVisible(true);
		pd.setResizable(false);
		privi = priv;
	}
	
	private void GUI_producto() 
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Producto");
		Container frame = this.getContentPane();
		
		
		frame.setLayout(null);
		
		JLabel lbidProd = new JLabel("Producto ID: ");
		JLabel lbdscrProd = new JLabel("Descripcion: ");
		JLabel lbprovProd = new JLabel("Proveedor: ");
		JLabel lbcatProd = new JLabel("Categoria: ");
		JLabel lbpreProd = new JLabel("Precio: ");
		JLabel lbcostProd = new JLabel("Costo: ");
		lbidProd.setBounds(80,30,120,50);
		lbdscrProd.setBounds(80,65,120,50);
		lbprovProd.setBounds(80,100,120,50);
		lbcatProd.setBounds(80,135,120,50);
		lbpreProd.setBounds(80,170,120,50);
		lbcostProd.setBounds(80,205,120,50);
		
		txtidProd = new JTextField();
		txtidProd.setBounds(170,43,70,20);
		txtdscrProd = new JTextField();
		txtdscrProd.setBounds(170,80,250,20);
		txtpreProd = new JTextField();
		txtpreProd.setBounds(170,185,70,20);
		txtcostProd = new JTextField();
		txtcostProd.setBounds(170,220,70,20);
		
		cbxprov = new JComboBox<String>();
		cbxprov.setBounds(170,110,105,20);
		txtdscrProv = new JTextField();
		cbxprov.addItem("Seleccione");
		cargar_proveedores();
		cbxprov.addActionListener(cbx_prov);
		//cbxprov.addItemListener((ItemListener) this);
		txtdscrProv.setBounds(280,110,120,20);
		txtdscrProv.setEnabled(false);
		txtdscrProv.setText("Proveedor");
		
		
		cbxcat = new JComboBox<String>();
		cbxcat.setBounds(170, 146, 105, 20);
		cbxcat.addItem("Seleccione");
		cargar_categoria();
		cbxcat.addActionListener(cbx_cat);
		//cbxcat.addItemListener((ItemListener) this);
		txtdscrCat = new JTextField();
		txtdscrCat.setBounds(280,146,120,20);
		txtdscrCat.setEnabled(false);
		txtdscrCat.setText("Categoria");
		
		
		btnalta = new JButton("Alta");
		btnact = new JButton("Actualizar");
		btngua = new JButton("Guardar");
		btncan = new JButton("Cancelar");
		btneli = new JButton("Eliminar");
		btnsal = new JButton("Salir");
		btnmen = new JButton("Menu");
		btnbus = new JButton("Buscar");
		
		btnalta.setBounds(80,300,95,30);
		btnact.setBounds(80,340,95,30);
		btngua.setBounds(190,300,95,30);
		btneli.setBounds(190,340,95,30);
		btncan.setBounds(300,300,95,30);
		btnsal.setBounds(300,340,95,30);
		btnmen.setBounds(500,300,95,50);
		btnbus.setBounds(500,40,95,30);
		
		frame.add(lbidProd);
		frame.add(lbdscrProd);
		frame.add(lbprovProd);
		frame.add(lbcatProd);
		frame.add(lbpreProd);
		frame.add(lbcostProd);
		
		frame.add(txtidProd);
		frame.add(txtdscrProd);
		frame.add(txtpreProd);
		frame.add(txtcostProd);
		frame.add(txtdscrProv);
		frame.add(txtdscrCat);
		
		frame.add(cbxprov);
		frame.add(cbxcat);
		
		frame.add(btnalta);
		frame.add(btnact);
		frame.add(btngua);
		frame.add(btneli);
		frame.add(btncan);
		frame.add(btnsal);
		frame.add(btnmen);
		frame.add(btnbus);
		
		
		btnalta.addActionListener(btn_alta);
		btnact.addActionListener(btn_act);
		btngua.addActionListener(btn_gua);
		btneli.addActionListener(btn_eli);
		btnbus.addActionListener(btn_bus);
		btnsal.addActionListener(btn_sal);
		btnmen.addActionListener(btn_menu);
	}
	
	ActionListener btn_menu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuAdmin ma = new MenuAdmin();
			ma.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btn_can = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			limpiarDatos();
		}
	};
	
	ActionListener btn_sal = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	};
	
	ActionListener btn_alta = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			limpiarDatos();
		}
	};
	
	ActionListener btn_bus = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int cveProd = Integer.parseInt(txtidProd.getText());
			ProductoCRUD pcrud = new ProductoCRUD();
			ProductoC prod = new ProductoC();
			
			prod.setCveProd(cveProd);
			
			ProductoC produ = pcrud.buscar(prod);
			if(produ != null) {
				txtidProd.setText(String.valueOf(produ.getCveProd()));
				txtdscrProd.setText(produ.getDscrProd());
				txtpreProd.setText(String.valueOf(produ.getPreProd()));
				txtcostProd.setText(String.valueOf(prod.getCostProd()));
				cbxprov.setSelectedItem(String.valueOf(prod.getProvProd()));
				cbxcat.setSelectedItem(String.valueOf(produ.getCatProd()));
			}
		}
	};
	
	ActionListener btn_act = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int cveProd = Integer.parseInt(txtidProd.getText()), provProd = Integer.parseInt(cbxprov.getSelectedItem().toString()), catProd = Integer.parseInt(cbxcat.getSelectedItem().toString());
			String dscrProd = txtdscrProd.getText();
			float preProd = Float.parseFloat(txtpreProd.getText()), costProd = Float.parseFloat(txtcostProd.getText());
			
			ProductoCRUD pcrud = new ProductoCRUD();
			
			ProductoC prod = new ProductoC(cveProd, dscrProd, provProd, catProd, 1, preProd, costProd);
			
			pcrud.buscar(prod);
			limpiarDatos();
		}
	};
	
	ActionListener btn_gua = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int cveProd = Integer.parseInt(txtidProd.getText()), provProd = Integer.parseInt(cbxprov.getSelectedItem().toString()), catProv = Integer.parseInt(cbxcat.getSelectedItem().toString());
			String dscrProd = txtdscrProd.getText();
			float preProd = Float.parseFloat(txtpreProd.getText()), costprod = Float.parseFloat(txtcostProd.getText());
			
			ProductoCRUD pcrud = new ProductoCRUD();
			
			ProductoC prod = new ProductoC();
			prod.setCveProd(cveProd);
			prod.setDscrProd(dscrProd);
			prod.setProvProd(provProd);
			prod.setCatProd(catProv);
			prod.setPreProd(preProd);
			prod.setCostProd(costprod);
			prod.setSabProd(1);
			
			pcrud.insertar(prod);
			limpiarDatos();
		}
	};
	
	ActionListener btn_eli = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int cveProd = Integer.parseInt(txtidProd.getText());
			
			ProductoCRUD pcrud = new ProductoCRUD();
			pcrud.eliminar(cveProd);
			limpiarDatos();
		}
	};
	
	ActionListener cbx_prov = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cargar_nomProv();
		}
	};
	
	ActionListener cbx_cat = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cargar_nomCat();
		}
	};
	
	private void salir() {
		this.dispose();
	}
	
	private void limpiarDatos() {
		txtidProd.setText(null);
		txtdscrProd.setText(null);
		txtdscrCat.setText(null);
		txtdscrProv.setText(null);
		txtcostProd.setText(null);
		txtpreProd.setText(null);
		cbxprov.setSelectedIndex(0);
		cbxcat.setSelectedIndex(0);
	}
	
	private void cargar_proveedores() {
		ProductoCRUD pcrud = new ProductoCRUD();
		pcrud.ConsultarProveedor(cbxprov);
	}
	
	private void cargar_nomProv() {
		String item = cbxprov.getSelectedItem().toString();
		ProductoCRUD pcrud = new ProductoCRUD();
		pcrud.ConsultarNomProv(item, txtdscrProv);
		
	}
	
	private void cargar_categoria() {
		ProductoCRUD pcrud = new ProductoCRUD();
		pcrud.ConsultarCategoria(cbxcat);
	}
	
	private void cargar_nomCat() {
		String item = cbxcat.getSelectedItem().toString();
		ProductoCRUD pcrud = new ProductoCRUD();
		pcrud.ConsultarNomCat(item, txtdscrCat);
		
	}
}
