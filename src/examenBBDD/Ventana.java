package examenBBDD;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 652);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setResizable(false);// no permite cambiar tamaño de ventana
		
		Dialogoconfirmar salir=new Dialogoconfirmar(this);
		addWindowListener(salir);
		setLocationRelativeTo(null);
		 JTabbedPane variospanel = new JTabbedPane();
		 AccionBotones acciones=new 	 AccionBotones();
	
		 Exportar_importar dato=new Exportar_importar();
		 variospanel.addTab("Consultar  Borrar Añadir Modificar ", acciones);
		 
		 variospanel.addTab("Exportar Importar ", dato);
		 
		 
		// variospanel.addTab("Actuarizar",actualizar);
		  setContentPane(variospanel);
		 
		 
	}

}

 class Dialogoconfirmar extends WindowAdapter{

	
	JFrame ventanaprincipal;
	
	Dialogoconfirmar(JFrame ventanaprincipal ){
		this.ventanaprincipal=ventanaprincipal;
	}
	
	public void windowClosing(WindowEvent e) {
		 int resultado= JOptionPane.showConfirmDialog(
				 this.ventanaprincipal, // para sale centro respectp a ventana principal 
				 "Seugro quieres salir ?",  // mensaje 
				 "Salir",   // dar titulo
				 JOptionPane.YES_NO_OPTION // YES =0, NO = 1 cancelar=2
				 //JOptionPane.CLOSED_OPTION  //CERRAR = -1
				 );
		 if(resultado==0) {
				System.exit(0);
		 }
		
	 }


}

