package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import backend.VentaCRUD;

@SuppressWarnings("serial")
public class Venta extends JFrame{
	
	JTextField txtordVta,txtidEmp,txtfechaVta,txtmetPagVta,txtcveVta,txtcantVta,txtprecioVta,txtdscrProd,txtsubTotVta,txtivaVta,txttotVtaVta,txtimpExtVta;
	JComboBox<String>cbxmetPagVta;
	JButton btnadd,btndel,btnsal,btncan,btnact,btnmen,btnreg,btncutbox;
	private JTable tabla; 
	
	DefaultTableModel modelo; // Modelo de Datos
	int cveProd;   //Producto
	int ordVta;   //Orden de Venta
	int nvaOrden, ordActual,orden1;
	int privi;
	/*public static void main(String[] args) {
		Venta vn = new Venta();
		vn.iniciar();
	}*/
	
	protected void iniciar(int priv) {
		Venta vn = new Venta();
		vn.GUI_venta();
		vn.setSize(720,800);//tama�o del Frame
		vn.setLocationRelativeTo(null);
		vn.setVisible(true);
		privi = priv;
	}

	private void GUI_venta() //metodo GUI_venta
	{
		Container frame = this.getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//creando instancia del frame se llama frame este es un objeto que tiene atributos
		this.setTitle("Venta");
		
		
		frame.setLayout(null);// esta es la distribucion de los elementos en el Frame y le estas diciendo que los posicione en forma absoluta es decir la posicion que el programador decida
		
		
		JLabel lbtitl = new JLabel("VENTAS MI PASTELERIA ");//Titulo
		
		JLabel lbtef = new JLabel("Telefono:00-000-000 "); // instnacia de una Etiqueta y su nombre cada vez que veas new estas creando una instancia y con ella controlas los atributos de ese objeto que creaste.
		JLabel lbordVta = new JLabel("Orden: ");
		JLabel lbidEmp = new JLabel("Vendedor: ");
		JLabel lbfechaVta = new JLabel("Fecha: ");
		JLabel lbmetPagVta = new JLabel("Metodo de pago: ");
		JLabel lbcveVta = new JLabel("Producto:");
		JLabel lbcantVta = new JLabel("Cantidad:");
		JLabel lbprecioVta = new JLabel("Precio:");
		JLabel lbsubTotVta = new JLabel("Subtotal:");
		JLabel lbivaVta = new JLabel("IVA:");
		JLabel lbtotVtaVta = new JLabel("Total:");
		JLabel lbimpExtVta = new JLabel("Imp Prod:");
		
		
		
		lbtitl.setBounds(290,10,150,50);// posicion de la etiqueta  con el atributo .setBounds
		lbtef.setBounds(297,30,120,50);
		lbordVta.setBounds(84,75,120,50);
		lbidEmp.setBounds(64,100,120,50);
		lbfechaVta.setBounds(456,75,120,50);
		lbmetPagVta.setBounds(400,100,120,50);
		lbcveVta.setBounds(66,150,100,50);
		lbcantVta.setBounds(68,175,100,50);
		lbprecioVta.setBounds(80,200,100,50);
		lbimpExtVta.setBounds(65,225,100,50);
		
		
		lbsubTotVta.setBounds(465,525,60,50);
		lbivaVta.setBounds(492,550,50,50);
		lbtotVtaVta.setBounds(484,573,50,50);
		
		
		
		
		txtordVta = new JTextField();   //Instanciado de la Caja de Texto creada anteriormente 
		txtordVta.setBounds(125,87,50,20);
		txtidEmp = new JTextField();
		txtidEmp.setBounds(125,115,200,20);
		txtfechaVta = new JTextField();
		txtfechaVta.setBounds(505,90,72,20);
		
		txtcveVta = new JTextField();
		txtcveVta.setBounds(125,165,75,20);
		txtcantVta = new JTextField();
		txtcantVta.setBounds(125,190,75,20);
		txtprecioVta = new JTextField();
		txtprecioVta.setBounds(125,215,75,20);
		
		txtimpExtVta = new JTextField();
		txtimpExtVta.setBounds(125,240,75,20);
		
		
		
		txtsubTotVta = new JTextField();
		txtsubTotVta.setBounds(520,538,70,20);
		txtivaVta = new JTextField();
		txtivaVta.setBounds(520,562,70,20);
		txttotVtaVta = new JTextField();
		txttotVtaVta.setBounds(520,586,70,20);
		
		
						
		// Descripcion(Mejorar)
		txtdscrProd = new JTextField();
		txtdscrProd.setBounds(210,165,130,20);
	
		
		cbxmetPagVta = new JComboBox<String>();///instancia de un Combo Box que tambien se nombro previamente como JComboBox<String>cbxmetPagVta;
		cbxmetPagVta.setBounds(505,115,90,20);
		cbxmetPagVta.addItem("Seleccione");
		cbxmetPagVta.addItem("Efectivo");
		cbxmetPagVta.addItem("Tarjeta");
		
		btnadd = new JButton("Agregar Producto");///instancia de un Boton que tambien se nombro previamente como JButton btnadd
		btndel = new JButton("Eliminar Producto");
		btnsal = new JButton("Salir");
		btncan = new JButton("Cancelar");
		btnact = new JButton("Actualizar");
		btnmen = new JButton("MENU");
		btnreg = new JButton("Registrar");
		btncutbox = new JButton("Corte_Caja");
		
		btnadd.setBounds(210,230,140,30);//posicion de los botones (coordentada X, Coordenada Y, Ancho del boton, Alto del Boton)
		btndel.setBounds(360,230,140,30);
		btnsal.setBounds(40,570,100,30);
		btnmen.setBounds(40,535,100,30);
		btncan.setBounds(150,570,100,30);
		btncutbox.setBounds(150,535,100,30);
		btnact.setBounds(260,570,100,30);
		btnreg.setBounds(260,535,100,30);
		
		
		modelo= new DefaultTableModel(); // Modelo de Datos de la Tabla  ,Cuantas columnas va a tener,los nombre de los encabezados y donde conslutara los datos que iran en ella.
				
		modelo.addColumn("Clave");//
		modelo.addColumn("Descripcion");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Importe");
		
		tabla = new JTable(modelo);
		tabla.setBounds(90,300,500,200);	
		tabla.setModel(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(90,300,500,200);
	
		
		frame.add(lbtitl);
		frame.add(lbtef);
		frame.add(lbordVta);
		frame.add(lbidEmp);
		frame.add(lbfechaVta);
		frame.add(lbmetPagVta);
		frame.add(lbcveVta);
		frame.add(lbcantVta);
		frame.add(lbprecioVta);
		frame.add(lbsubTotVta);
		frame.add(lbivaVta);
		frame.add(lbtotVtaVta);
		frame.add(lbimpExtVta);
		
		frame.add(txtordVta);
		frame.add(txtidEmp);
		frame.add(txtfechaVta);
		frame.add(txtcveVta);
		frame.add(txtcantVta);
		frame.add(txtprecioVta);
		frame.add(txtdscrProd);
		frame.add(txttotVtaVta);
		frame.add(txtsubTotVta);
		frame.add(txtivaVta);
		frame.add(txtimpExtVta);
		
		frame.add(cbxmetPagVta);
		
		frame.add(btnadd);
		frame.add(btndel);
		frame.add(btnsal);
		frame.add(btncan);
		frame.add(btnact);
		frame.add(btncutbox);
		frame.add(btnreg);
		frame.add(btnmen);
		frame.add(tabla);
		frame.add(scroll);
	
		tabla.setVisible(true);
		
		btnadd.addActionListener(btn_add);
		btnreg.addActionListener(btn_reg);
		btndel.addActionListener(btn_del);
		btncan.addActionListener(btn_can);
		btnmen.addActionListener(btn_men);
		btnsal.addActionListener(btn_sal);
	}
	
	ActionListener btn_sal = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	};
	
	ActionListener btn_men = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuVenta mv = new MenuVenta();
			mv.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btn_del = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = tabla.getRowCount() - 1;
			modelo.removeRow(index);
		}
	};
	
	ActionListener btn_add = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			VentaCRUD vcrud = new VentaCRUD();
			int cantProd = Integer.parseInt(txtcantVta.getText());
			float preProd = vcrud.precio(cantProd) * cantProd;
			
			String fila[] = {txtordVta.getText(), txtdscrProd.getText(), txtcantVta.getText(), String.valueOf(preProd), txtimpExtVta.getText()};
			modelo.addRow(fila);
		}
	};
	
	ActionListener btn_reg = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(tabla.getRowCount() > 0) {
				VentaCRUD vcrud = new VentaCRUD();
				for(int i = 0; i < tabla.getRowCount(); i++) {
					vcrud.insertar(Integer.parseInt(txtordVta.getText()), Integer.parseInt(txtcveVta.getText()), Integer.parseInt(txtcantVta.getText()), Float.parseFloat(txtimpExtVta.getText()));
				}
			}
		}
	};
	
	ActionListener btn_can = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			limpiarDatos();
		}
	};
	
	private void salir() {
		this.dispose();
	}
	
	private void limpiarDatos() {
		txtordVta.setText(null);
		txtidEmp.setText(null);
		txtfechaVta.setText(null);
		txtmetPagVta.setText(null);
		txtcveVta.setText(null);
		txtcantVta.setText(null);
		txtprecioVta.setText(null);
		txtdscrProd.setText(null);
		txtsubTotVta.setText(null);
		txtivaVta.setText(null);
		txttotVtaVta.setText(null);
		txtimpExtVta.setText(null);
		
		modelo.rowsRemoved(null);
	}
}
