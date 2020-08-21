package examenBBDD;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Borrar  {

	/**
	 * Create the panel.
	 */	public JRadioButton rdbtnUsuario;
		public JRadioButton rdbtnVechiculo;
		ButtonGroup grupousuariovehiculo;
		JTextField textUsuario;
		JTextField textVehiculo;
		String DNI;
		 JLabel Aviso;
	public	 String Matricula;
	JButton btnmodificar;
		 
	public Borrar(JRadioButton rdbtnUsuario, JRadioButton rdbtnVechiculo,ButtonGroup grupousuariovehiculo,JTextField textUsuario
			,JTextField textVehiculo, JLabel Aviso,JButton btnmodificar) {
	 this.rdbtnUsuario=rdbtnUsuario;
	 this.rdbtnVechiculo=rdbtnVechiculo;
	 this.grupousuariovehiculo=grupousuariovehiculo;
	 this.textUsuario=textUsuario;
	 this.textVehiculo=textVehiculo;
	 this.Aviso=Aviso;
	 this.btnmodificar=btnmodificar;
	
	}
	
	public void accionborrar() {
		
		
				BBDD base=new BBDD();
				OperacionVehiculo opevehiculo=new OperacionVehiculo(base);
				Operacion_usuario opeusuario=new Operacion_usuario(base);
		if(grupousuariovehiculo.getSelection().equals(rdbtnUsuario.getModel()))
				{	
					DNI=textUsuario.getText();	
					if(Comprobar.vacio_usario(DNI, Aviso)) {
				
							if(opeusuario.consultarUsuario(DNI)) {
									if(seguro(DNI,2)==0) {// (2) igual mensaje si quiere borrar usuario, ==0 en caso 
										// que ha elegido si devueve un 0
										
										if(opevehiculo.accionvehiculo(DNI, "BorrarconDNI")&&opeusuario.AccionUsuario(DNI, "Borrar"))
											{
											 btnmodificar.setEnabled(false);
											TextodeAviso.Borradoexito(Aviso);
											}
										else TextodeAviso.Borrarfracasado(Aviso);
									}
							}else TextodeAviso.UsuarioNoexiste(DNI, Aviso);
				      }
				}		
					
	else if(grupousuariovehiculo.getSelection().equals(rdbtnVechiculo.getModel())){
			Matricula=textVehiculo.getText();
			if(Comprobar.vacio_vehiculo(Matricula, Aviso)) {		
				if(opevehiculo.consultarVehiculo(Matricula, "conMatricula")) { 
					 if( seguro(Matricula,0)==0	) {//(0) igual mensaje sobre vehiculo , ==0 si ha pulsado que si esta seguro de borrar
						 if( opevehiculo.accionvehiculo(Matricula, "BorrarconMatricula")&&opeusuario.AccionUsuario(base.getDNI(), "Borrar")) {
						     TextodeAviso.Borradoexito(Aviso);
						     btnmodificar.setEnabled(false);
						 	}
						 else TextodeAviso.Borrarfracasado(Aviso);
						}
					}else  TextodeAviso.Matricanoexiste(Matricula, Aviso);
				}
			}	
		base.cerrar();
		}
	

	public int seguro(String que,int cual) {
		
		String mensaje;
		if(cual==2) mensaje="Seugro quieres eliminar el usuario "+que+" y su vehiculo?";
		else mensaje="Seugro quieres eliminar el vehiculo: "+que+" y su dueño ?";
		int resultado= JOptionPane.showConfirmDialog(// preguntar al usuario si esta seguro de borrar datos
					// en caso ha elegido YES devuele un 0 
				 null, 
				 mensaje,  // mensaje 
				 "Seguro",   // dar titulo
				 JOptionPane.YES_NO_OPTION // YES =0, NO = 1 cancelar=2
				 //JOptionPane.CLOSED_OPTION  //CERRAR = -1
				 );
		return resultado;
	}
	
}
