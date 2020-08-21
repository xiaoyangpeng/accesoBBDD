package examenBBDD;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Modificar extends Insertar{

	
	String telefonoantes;
	String Matriculaantes;


	public Modificar(JTextField textDNI, JTextField textNombre, JTextField textTelefono, JTextField textEdad,
			JTextField textFechaYHora, JLabel Aviso, JTextField textUsuario, JTextField textVehiculo,
			JTextField textMatricula, JTextField textPeso, JTextField textMarca, JRadioButton sexoH, JRadioButton sexoM,
			JRadioButton rdbtnL, JRadioButton rdbM, JRadioButton rdbtnN, JRadioButton rdbtnUsuario,
			JRadioButton rdbtnVechiculo, ButtonGroup gruposexo, ButtonGroup grupocategria,
			ButtonGroup grupousuariovehiculo,JButton btnmodificar) {
		super(textDNI, textNombre, textTelefono, textEdad, textFechaYHora, Aviso, textUsuario, textVehiculo, textMatricula,
				textPeso, textMarca, sexoH, sexoM, rdbtnL, rdbM, rdbtnN, rdbtnUsuario, rdbtnVechiculo, gruposexo, grupocategria,
				grupousuariovehiculo, btnmodificar);
		// TODO Auto-generated constructor stub
		

	}
	
	public void accionmodificar() {
		
		BBDD base=new BBDD();
		OperacionVehiculo opevehiculo=new OperacionVehiculo(base);
		Operacion_usuario opeusuario=new Operacion_usuario(base);
		ButtonModel cual=grupousuariovehiculo.getSelection();// ver que JRadioButton ha elegido
	
		DNI=textDNI.getText();// este DNI coger¨¢ DNI de abajo , que ha  conseguido 
		// con accion de consultar, asi aseguro que el usuario no se puede moficar DNI
		// porque DNI es clave principal no permite modifcar 
	
		
			if(usuariovacio()&&vehiculovacio()) { 
				if(campoUsuario(base)&&campovehiculo(opevehiculo)) {
						setusuario(base);
						setvehiculo(base);// aqui no hay setFehca y hora porque ,no permite modifcar
				// fecha y hora genera automaticamente cuando insertar un usuario nuevo
						
							if(setBBDD(opevehiculo, opeusuario)) btnmodificar.setEnabled(false);
							else TextodeAviso.ErrorenBBDD(Aviso);
					}
				}
		base.cerrar();
	}
	
	@Override
	public boolean setBBDD(OperacionVehiculo opevehiculo,Operacion_usuario opeusuario) {
		if(opeusuario.AccionUsuario(DNI, "Modificar")&&opevehiculo.accionvehiculo(DNI, "Modificar")){
			Aviso.setText("Datos modifcado con exito");
			return true;
		}
		return false;
	}
	
	public boolean campoUsuario(BBDD base) {
		
		// cada vez que fallo devuelve enseguida, no va a ejecutar m¨¢s 
		
		telefonoantes=base.telefono_DNI(DNI);
		
		// primero comprobar si lo que esta poniendo es igual 
		// su original telefono , en caso de no, llamar metodo de comprobar telefono
		if(!textTelefono.getText().equals(telefonoantes)) {
			if(!Comprobar.Telefono(base, textTelefono.getText(), Aviso)) return false;
			if(base.telefono(textTelefono.getText())) 
				{TextodeAviso.yaexistelefono(Aviso);
				return false;
				}
		}
		if(!Comprobar.Edad(textEdad.getText(), Aviso)) return false;
		return true;
	}

	
	
	public boolean campovehiculo(OperacionVehiculo opevehiculo) {
		Matriculaantes=textMatricula.getText();
		if(!opevehiculo.consultarMatriucla(DNI).equals(Matriculaantes)) {
			//comprobar si matricula que ha puesto usuario es igual que antes
			if(!Comprobar.Matricula(Matriculaantes, Aviso)) {return false;}
			else if(opevehiculo.consultarVehiculo(textMatricula.getText(), "conMatricula")){
				TextodeAviso.Matricayaexiste(textMatricula.getText(), Aviso);
				return false;
			}
		}
		if(!Comprobar.peso(textPeso.getText(), Aviso)) { return false;}
		
		return true;
	}
	
}
