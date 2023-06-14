package ventanas;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Menu extends JFrame{
	JButton btn_salir, btn_vnt, btn_comp, btn_inv, btn_admin;
	int privi;
	/*public static void main(String[] args) {
		Menu mn = new Menu();
		mn.iniciar();
	}*/
	
	protected void iniciar(int priv) {
		Menu mn = new Menu();
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
		
		JLabel lb_mn = new JLabel("Menu");
		
		btn_vnt = new JButton("Ventas");
		btn_comp = new JButton("Compras");
		btn_salir = new JButton("Salir");
		btn_inv = new JButton("Inventario");
		btn_admin = new JButton("Admin");
		
		lb_mn.setBounds(180, 30, 150, 40);
		btn_vnt.setBounds(170, 330, 150, 40);
		btn_comp.setBounds(170, 250, 150, 40);
		btn_salir.setBounds(170, 410, 150, 40);
		btn_inv.setBounds(170, 170, 150, 40);
		btn_admin.setBounds(170, 100, 150, 40);
		
		lb_mn.setFont(new Font("Arial", Font.PLAIN, 50));
		/*btn_cut.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_vnt.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_comp.setFont(new Font("Arial", Font.PLAIN, 30));*/
		
		frame.add(lb_mn);
		frame.add(btn_vnt);
		frame.add(btn_comp);
		frame.add(btn_salir);
		frame.add(btn_admin);
		frame.add(btn_inv);
		
		if(priv == 2) {
			btn_admin.setEnabled(false);
			btn_comp.setEnabled(false);
		}else if(priv == 3) {
			btn_admin.setEnabled(false);
			btn_vnt.setEnabled(false);
		}
		
		
		btn_admin.addActionListener(btnadmin);
		btn_salir.addActionListener(btnsal);
		btn_comp.addActionListener(btncomp);
		btn_vnt.addActionListener(btnvnt);
		
	}
	
	ActionListener btnsal = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	};
	
	ActionListener btnadmin = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuAdmin ma = new MenuAdmin();
			ma.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btncomp = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuCompra mc = new MenuCompra();
			mc.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btnvnt = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuVenta mv = new MenuVenta();
			mv.iniciar(privi);
			salir();
		}
	};
	
	private void salir() {
		this.dispose();
	}
}
