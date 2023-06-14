package ventanas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Cortecaja extends JFrame{

	JTextField txtidCorteCaja,txtidEmpCorteCaja,txtimpCorteCaja,txtimpFisicoCorteCaja,txtretiroCorteCaja,txtidSaldoCorteCaja;
	JButton btnact,btnreg,btngua,btncan,btnmen,btnsal;
	int privi;
	/*public static void main(String[] args) {
		Cortecaja ctc = new Cortecaja(); 
		ctc.iniciar();
	}*/
	
	protected void iniciar(int priv) {
		Cortecaja ctc = new Cortecaja();
		ctc.GUI_Cortecaja();
		ctc.setSize(500,500);
		ctc.setLocationRelativeTo(null);
		ctc.setVisible(true);
		ctc.setResizable(false);
		privi = priv;
	}
	
	private void GUI_Cortecaja() 
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Corte de caja");
		Container frame = this.getContentPane();
		frame.setLayout(null);
		
		
		JLabel lbidCorteCaja = new JLabel("Corte No.: ");
		JLabel lbidEmpCorteCaja = new JLabel("Empleado: ");
		JLabel lbimpCorteCaja= new JLabel("Importe Corte: ");
		JLabel lbimpFisicoCorteCaja = new JLabel("Importe Fisico: ");
		JLabel lbretiroCorteCaja = new JLabel("Efectivo Retirado: ");
		JLabel lbidSaldoCorteCaja = new JLabel("Nuevo Saldo: ");
		
		lbidCorteCaja.setBounds(130, 0, 120, 50);
		lbidEmpCorteCaja.setBounds(125,30 , 120, 50);
		lbimpCorteCaja.setBounds(102, 60, 120, 50);
		lbimpFisicoCorteCaja.setBounds(100,90 , 120, 50);
		lbretiroCorteCaja.setBounds(80, 120, 120, 50);
		lbidSaldoCorteCaja .setBounds(107,150 , 120, 50);
		
		txtidCorteCaja = new JTextField();
		txtidCorteCaja.setBounds(200, 12, 70, 20);
		txtidEmpCorteCaja = new JTextField();
		txtidEmpCorteCaja.setBounds(200, 43, 250, 20);
		txtimpCorteCaja = new JTextField();
		txtimpCorteCaja.setBounds(200, 74, 70, 20);
		txtimpFisicoCorteCaja = new JTextField();
		txtimpFisicoCorteCaja.setBounds(200,102, 70, 20);
		txtretiroCorteCaja = new JTextField();
		txtretiroCorteCaja.setBounds(200, 135, 70, 20);
		txtidSaldoCorteCaja = new JTextField();
		txtidSaldoCorteCaja.setBounds(200, 165, 70, 20);
		
		btnact = new JButton("Actualizar");
		btnreg = new JButton("Registrar Corte");
		btngua = new JButton("Guardar");
		btncan = new JButton("Cancelar");
		btnmen = new JButton("Men�");
		btnsal = new JButton("Salir");
		
		btnact.setBounds(80, 320, 95, 30);
		btnreg.setBounds(80, 360,95, 30);
		btngua.setBounds(190, 320, 95, 30);
		btncan.setBounds(300, 360, 95, 30);
		btnmen.setBounds(190, 360, 95, 30);
		btnsal.setBounds(300, 320, 95, 30);
		
		frame.add(lbidCorteCaja);
		frame.add(lbidEmpCorteCaja);
		frame.add(lbimpCorteCaja);
		frame.add(lbimpFisicoCorteCaja);
		frame.add(lbretiroCorteCaja);
		frame.add(lbidSaldoCorteCaja);
		
		
		frame.add(txtidCorteCaja);
		frame.add(txtidEmpCorteCaja);
		frame.add(txtimpCorteCaja);
		frame.add(txtimpFisicoCorteCaja);
		frame.add(txtretiroCorteCaja);
		frame.add(txtidSaldoCorteCaja);
		
		frame.add(btnact );
		frame.add(btnreg);
		frame.add(btngua);
		frame.add(btncan);
		frame.add(btnmen);
		frame.add(btnsal);
		
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
	
	private void salir() {
		this.dispose();
	}
}
