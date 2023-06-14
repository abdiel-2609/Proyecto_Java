package ventanas;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuVenta extends JFrame{
	JButton btn_salir, btn_inv, btn_corte, btn_repVenta, btn_puntVenta, btn_menu;
	int privi;
	/*public static void main(String[] args) {
		MenuVenta mn = new MenuVenta();
		mn.iniciar();
	}*/

	protected void iniciar(int priv) {
		MenuVenta mn = new MenuVenta();
		mn.GUI(priv);
		mn.setSize(500, 600);
		mn.setLocationRelativeTo(null);
		mn.setVisible(true);
	}
	
	protected void GUI(int priv) {
		privi = priv;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Menu de Venta");
		Container frame = this.getContentPane();
		
		frame.setLayout(null);
		
		JLabel lb_mn = new JLabel("Menu Vendedor");
		
		btn_inv = new JButton("Inventario");
		btn_corte = new JButton("Corte de Caja");
		btn_salir = new JButton("Salir");
		btn_repVenta = new JButton("Reporte de Venta");
		btn_puntVenta = new JButton("Punto de Venta");
		btn_menu = new JButton("Menu");
		
		lb_mn.setBounds(130, 30, 300, 40);
		btn_inv.setBounds(170, 330, 150, 40);
		btn_corte.setBounds(170, 250, 150, 40);
		btn_salir.setBounds(290, 410, 150, 40);
		btn_repVenta.setBounds(170, 170, 150, 40);
		btn_puntVenta.setBounds(170, 100, 150, 40);
		btn_menu.setBounds(50, 410, 150, 40);
		
		lb_mn.setFont(new Font("Arial", Font.PLAIN, 30));
		/*btn_cut.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_vnt.setFont(new Font("Arial", Font.PLAIN, 30));
		btn_comp.setFont(new Font("Arial", Font.PLAIN, 30));*/
		
		frame.add(lb_mn);
		frame.add(btn_inv);
		frame.add(btn_corte);
		frame.add(btn_salir);
		frame.add(btn_puntVenta);
		frame.add(btn_repVenta);
		frame.add(btn_menu);
		
		/*btn_admin.addActionListener(btnadmin);
		btn_vnt.addActionListener(btnvnt);
		btn_comp.addActionListener(btncomp);
		btn_prov.addActionListener(btnprov);
		btn_cat.addActionListener(btncat);
		btn_emp.addActionListener(btnemp);*/
		btn_menu.addActionListener(btnmenu);
		btn_salir.addActionListener(btnsal);
		btn_corte.addActionListener(btncorte);
		btn_puntVenta.addActionListener(btnpuntVenta);
	}
	
	ActionListener btncorte = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Cortecaja cc = new Cortecaja();
			cc.iniciar(privi);
			salir();
		}
	};
	
	ActionListener btnpuntVenta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Venta vnt = new Venta();
			vnt.iniciar(privi);
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
