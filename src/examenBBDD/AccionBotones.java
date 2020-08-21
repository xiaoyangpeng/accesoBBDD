package examenBBDD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;


public class AccionBotones extends Panel_modelo {

	
	
	public AccionBotones() {
		elegir();
		consultar();
		borrar();
		insertat();
		modificar();
		vaciarcampo();
	}
	
	
	void consultar() {
		btnconsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TextodeAviso.limpia(Aviso);
				Consultar consulta=new Consultar(textDNI, textNombre,
						textTelefono, textEdad, textFechaYHora, Aviso, textUsuario,
						textVehiculo, btnmodificar, textMatricula, textPeso, textMarca, 
						sexoH, sexoM, rdbtnL, rdbM, rdbtnN, rdbtnUsuario, rdbtnVechiculo,
						grupousuariovehiculo);
				
				consulta.BotonConsultar();
			
			}
		});
		
	}
	void borrar() {
		btnborrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TextodeAviso.limpia(Aviso);
				btnmodificar.setEnabled(false);// boton midificar solo activa cunado hace una consulta correcta
				Borrar borra=new Borrar(rdbtnUsuario, rdbtnVechiculo, 
						grupousuariovehiculo, textUsuario, textVehiculo, Aviso,btnmodificar);
				borra.accionborrar();
			}
		});
	}
	
	void insertat() {
		btnInsertat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnmodificar.setEnabled(false);
				Insertar inserta=new Insertar(textDNI, textNombre, textTelefono,
						textEdad, textFechaYHora, Aviso, textUsuario, textVehiculo,
						textMatricula, textPeso, textMarca, sexoH, sexoM, rdbtnL, rdbM, 
						rdbtnN, rdbtnUsuario, rdbtnVechiculo, gruposexo, grupocategria, grupousuariovehiculo
						,btnmodificar);
			
					inserta.accionInsertar();
			}
			
		});
	}
 
	void modificar() {
		btnmodificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Modificar modifica=new Modificar(textDNI, textNombre, textTelefono,
						textEdad, textFechaYHora, Aviso, textUsuario, textVehiculo,
						textMatricula, textPeso, textMarca, sexoH, sexoM, rdbtnL, rdbM, 
						rdbtnN, rdbtnUsuario, rdbtnVechiculo, gruposexo, grupocategria, grupousuariovehiculo,btnmodificar);
			modifica.accionmodificar();	
			}
		});
	}
 void vaciarcampo() {
	 btnVaciar.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			vaciar();
		}
	});
 }
 
 
	public void elegir() {
		rdbtnUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textUsuario.setEnabled(true);
				textVehiculo.setEnabled(false);
				textVehiculo.setText("");
			}
		});
		rdbtnVechiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textUsuario.setEnabled(false);
				textVehiculo.setEnabled(true);
				textUsuario.setText("");
			}
		});
}
	
	
 
}
