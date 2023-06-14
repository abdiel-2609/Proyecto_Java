package ventanas;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuAdmin extends JFrame{
	
	JButton btn_salir, btn_emp, btn_prov, btn_cat, btn_prod, btn_menu;
	int privi;
	/*public static void main(String[] args) {
		MenuAdmin mn = new MenuAdmin();
		mn.iniciar();
	}*/

	protected void iniciar(int priv) {
		MenuAdmin mn = new MenuAdmin();
		mn.GUI(priv);
		mn.setSize(500, 600);
		mn.setLocationRelativeTo(null);
		mn.setVisible(true);
	}
	
	protected void GUI(int priv) {
		privi = priv;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Menu de Administrador");
		Container frame = this.getContentPane();
		
		frame.setLayout(null);
		
		JLabel lb_mn = new JLabel("Menu Aministrador");
		
		btn_emp = new JButton("Empleado");
		btn_prov = new JButton("Proveedor");
		btn_salir = new JButton("Salir");
		btn_cat = new JButton("Categoria");
		btn_prod = new JButton("Producto");
		btn_menu = new JButton("Menu");
		
		lb_mn.setBounds(130, 30, 300, 40);
		btn_emp.setBounds(170, 330, 150, 40);
		btn_prov.setBounds(170, 250, 150, 40);
		btn_salir.setBounds(290, 410, 150, 40);
		btn_cat.setBounds(170, 170, 150, 40);
		btn_prod.setBounds(170, 100, 150, 40);
		btn_menu.setBounds(50, 410, 150, 40);
		
		lb_mn.setFont(new Font("Arial", Font.PLAIN, 30));
		/*btn_cut.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_vnt.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_comp.setFont(new Font("Arial", Font.PLAIN, 30));*/
		
		frame.add(lb_mn);
		frame.add(btn_emp);
		frame.add(btn_prov);
		frame.add(btn_salir);
		frame.add(btn_prod);
		frame.add(btn_cat);
		frame.add(btn_menu);
		
		/*btn_admin.addActionListener(btnadmin);
		btn_vnt.addActionListener(btnvnt);
		btn_comp.addActionListener(btncomp);*/
		btn_prov.addActionListener(btnprov);
		btn_cat.addActionListener(btncat);
		btn_emp.addActionListener(btnemp);
		btn_menu.addActionListener(btnmenu);
		btn_prod.addActionListener(btnprod);
	}
	
	ActionListener btnprod = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Producto prov = new Producto();
			prov.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btnprov = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Proveedor prov = new Proveedor();
			prov.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btnemp= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Empleado emp = new Empleado();
			emp.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btncat = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Categoria cat = new Categoria();
			cat.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btnsal = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	};
	
	ActionListener btnmenu = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Menu mn = new Menu();
			mn.iniciar(privi);
			salir();
		}
	};
	
	private void salir() {
		this.dispose();
	}
}
