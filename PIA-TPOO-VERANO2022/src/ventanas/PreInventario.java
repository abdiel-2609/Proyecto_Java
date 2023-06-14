package ventanas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PreInventario extends JFrame implements ActionListener{
	
	JButton btnInventario, btnMenu, btnSalir;
	
	public static void main(String[] args) {
		PreInventario PB = new PreInventario();
		PB.iniciar();
	}
	
	protected void iniciar() {
		PreInventario PB = new PreInventario();
		PB.crearInven();
		PB.setSize(200,250);
		PB.setResizable(false);
		PB.setVisible(true);
	}
	private void crearInven() 
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Menu");
		Container frame =this.getContentPane();
		frame.setLayout(new FlowLayout());
		
		btnInventario = new JButton("   Inventario   ");
		btnInventario.addActionListener(this);
		frame.add(btnInventario);
		
		btnMenu = new JButton(" Menu ");
		btnMenu.addActionListener(this);
		frame.add(btnMenu);
		
		
		btnSalir = new JButton(" Salir ");
		btnSalir.addActionListener(this);
		frame.add(btnSalir);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}