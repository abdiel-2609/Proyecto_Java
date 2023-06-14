package ventanas;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuCompra extends JFrame{
	
	JButton btn_salir, btn_emp, btn_inv, btn_ordComp, btn_repComp, btn_menu;
	int privi;
	/*public static void main(String[] args) {
		MenuCompra mn = new MenuCompra();
		mn.iniciar();
	}*/

	protected void iniciar(int priv) {
		MenuCompra mn = new MenuCompra();
		mn.GUI(priv);
		mn.setSize(500, 600);
		mn.setLocationRelativeTo(null);
		mn.setVisible(true);
	}
	
	protected void GUI(int priv) {
		privi = priv;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Joyería");
		Container frame = this.getContentPane();
		
		frame.setLayout(null);
		
		JLabel lb_mn = new JLabel("Menu Comprador");
		
		//btn_emp = new JButton("Empleado");
		btn_inv = new JButton("Inventario");
		btn_salir = new JButton("Salir");
		btn_ordComp = new JButton("Orden de Compra");
		btn_repComp = new JButton("Reporte de Compra");
		btn_menu = new JButton("Menu");
		
		lb_mn.setBounds(130, 30, 300, 40);
		//btn_emp.setBounds(170, 330, 150, 40);
		btn_inv.setBounds(170, 250, 150, 40);
		btn_salir.setBounds(290, 410, 150, 40);
		btn_ordComp.setBounds(170, 170, 150, 40);
		btn_repComp.setBounds(170, 100, 150, 40);
		btn_menu.setBounds(50, 410, 150, 40);
		
		lb_mn.setFont(new Font("Arial", Font.PLAIN, 30));
		/*btn_cut.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_vnt.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_comp.setFont(new Font("Arial", Font.PLAIN, 30));*/
		
		frame.add(lb_mn);
		//frame.add(btn_emp);
		frame.add(btn_inv);
		frame.add(btn_salir);
		frame.add(btn_ordComp);
		frame.add(btn_repComp);
		frame.add(btn_menu);
		
		/*btn_admin.addActionListener(btnadmin);
		btn_vnt.addActionListener(btnvnt);
		btn_comp.addActionListener(btncomp);
		btn_prov.addActionListener(btnprov);
		btn_cat.addActionListener(btncat);
		btn_emp.addActionListener(btnemp);*/
		btn_menu.addActionListener(btnmenu);
		btn_salir.addActionListener(btnsal);
	}
	
	ActionListener btnmenu = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Menu mn = new Menu();
			mn.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btnsal = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	};
	
	private void salir() {
		this.dispose();
	}
}
