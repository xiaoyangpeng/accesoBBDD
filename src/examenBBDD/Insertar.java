package examenBBDD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Insertar {
	protected String DNI;
	public String Matricula;
	 String Peso;
 String Marca;
 String Categoria;
	  JTextField textDNI;
      JTextField textNombre;
     JTextField textTelefono;
     JTextField textEdad;
	 JTextField textFechaYHora;
	 JLabel Aviso;
	 JTextField textUsuario;
	 JTextField textVehiculo;
	JTextField textMatricula;
	JTextField textPeso;
	JTextField textMarca;
	JRadioButton sexoH;
	JRadioButton sexoM ;
	JRadioButton rdbtnL ;
	JRadioButton rdbM  ;
	JRadioButton rdbtnN ;
	JRadioButton rdbtnUsuario;
	JRadioButton rdbtnVechiculo;
	ButtonGroup grupousuariovehiculo;
	ButtonGroup gruposexo;
	ButtonGroup grupocategria;
	JButton btnmodificar;
	public Insertar(JTextField textDNI, JTextField textNombre,JTextField textTelefono,
   JTextField textEdad, JTextField textFechaYHora, JLabel Aviso, JTextField textUsuario,
	JTextField textVehiculo,JTextField textMatricula,JTextField textPeso,JTextField textMarca,JRadioButton sexoH,
	JRadioButton sexoM ,JRadioButton rdbtnL ,JRadioButton rdbM  ,JRadioButton rdbtnN ,JRadioButton rdbtnUsuario,
	JRadioButton rdbtnVechiculo,ButtonGroup gruposexo,
	ButtonGroup grupocategria,ButtonGroup grupousuariovehiculo,JButton btnmodificar){
		this.textDNI=textDNI;  this.textNombre=textNombre;  this.textTelefono= textTelefono;
	     this.textEdad= textEdad; this.textFechaYHora= textFechaYHora;
		this.Aviso= Aviso;this.textUsuario = textUsuario; this.textVehiculo= textVehiculo;
		this.textMatricula = textMatricula;this.textPeso=textPeso;this.textMarca =textMarca;this.sexoH =sexoH;
		this.sexoM=sexoM ;this.rdbtnL= rdbtnL ;this.rdbM = rdbM  ;this.rdbtnN=rdbtnN ;
		this.rdbtnUsuario=rdbtnUsuario;this.rdbtnVechiculo= rdbtnVechiculo;this.grupousuariovehiculo= grupousuariovehiculo;
		this.gruposexo=gruposexo;this.grupocategria= grupocategria;
		this.btnmodificar=btnmodificar;
		
	}
	
	void accionInsertar() {
		BBDD base=new BBDD();
		OperacionVehiculo opevehiculo=new OperacionVehiculo(base);
		Operacion_usuario opeusuario=new Operacion_usuario(base);
		ButtonModel cual=grupousuariovehiculo.getSelection();// ver que JRadioButton ha elegido

			
		DNI=textUsuario.getText();	
		Matricula=textMatricula.getText();

	if(rdbtnVechiculo.isSelected()) {TextodeAviso.Hayqueelegirusario(Aviso);}
		
	else {
			if(Comprobar.vacio_usario(DNI, Aviso)) {
					if(usuariovacio()&&vehiculovacio()) { // comprobar que los campos no son vacíos
							
								if(campoUsuario(base, opeusuario)&&campovehiculo(opevehiculo))//comprobar campos de usuario son correctos
								{
										setusuario(base);
										setFechayhora(base);// fecha y hora genera automaticamente 
										setvehiculo(base);
										btnmodificar.setEnabled(false);
										if(setBBDD(opevehiculo, opeusuario)) {
											Aviso.setText("Datos insertado con exito");
										}
										else TextodeAviso.ErrorenBBDD(Aviso);
								}
						
						}
				}
	}
			base.cerrar();
}
	
	
	public boolean setBBDD(OperacionVehiculo opevehiculo,Operacion_usuario opeusuario) {
		if(opeusuario.AccionUsuario(DNI, "Insertar")&&opevehiculo.accionvehiculo(DNI, "Insertar")){
			Aviso.setText("Datos insertado con exito");
			return true;
		}
		return false;
	}
	
	
	
public boolean campoUsuario(BBDD base,Operacion_usuario opeusuario) {
	
	
	if(!Comprobar.DNI(DNI, Aviso)) return false;// comprobar formato DNI
	if(opeusuario.consultarUsuario(DNI)) { //comprobar existencia de DNI en BBDD
		TextodeAviso.Usuarioyaexiste(DNI, Aviso);
		return false;
	}
	if(!Comprobar.Telefono(base,textTelefono.getText(), Aviso)) return false;//comprobar formato de telefono
	
	if(base.telefono(textTelefono.getText())) {//comporbar existencia de Telefono
			TextodeAviso.yaexistelefono(Aviso);
			return false;
			}
	if(!Comprobar.Edad(textEdad.getText(), Aviso)) return false;// comprobar formato de edad
	return true;
}



public boolean usuariovacio() {
	if(
	gruposexo.getSelection()==null||
	textNombre.getText().equals("") ||
	textEdad.getText().equals("")||
	textTelefono.getText().equals("")
	) {
		Aviso.setText("Hay campo de usuario esta vacío");
		return false;
	}

	return true;
}



public boolean vehiculovacio() {// comprobar si campovehiculo esta vacio 
	
	if(
		grupocategria.getSelection()==null||
		textMarca.getText().equals("")||
		textPeso.getText().equals("")||
		textMatricula.getText().equals("")
		) 
	{
		 Aviso.setText(
					"<html><body>Hay campos de vehículo<br>"
					+ " estan vacío</html></body>");
		 return false;
	}
	
	return true;
}

public boolean campovehiculo(OperacionVehiculo opevehiculo) {
	
	if(Comprobar.Matricula(textMatricula.getText(), Aviso)) {// comprobar formato de Matricula
		if(opevehiculo.consultarVehiculo(Matricula, "conMatricula")) {// comprobar si existe Matricula
			TextodeAviso.Matricayaexiste(Matricula, Aviso);
			return false;
		}
	}
	else	return false;
	
	if(!Comprobar.peso(textPeso.getText(),Aviso) ) 	return false;// comprobar formato de peso
	
	return true;
	
}
	
	public void setusuario(BBDD base) {
	
		base.setDNI(DNI);
		base.setTelefono(Integer.parseInt(textTelefono.getText()));
		base.setSexo(sexo());
		base.setEdad(Integer.parseInt(textEdad.getText()));
		base.setNombre(textNombre.getText());

		
	}
	
	public void setFechayhora(BBDD base) {
		base.setFehcayhora(tiempo());
	}
	
	
	public void setvehiculo(BBDD base) {

		base.setCategoria(categoria());
		base.setMarca(textMarca.getText());
		base.setPeso(textPeso.getText());
		base.setMatricula(textMatricula.getText());
		
		
}

	public String categoria() {
		if(grupocategria.getSelection().equals(rdbM.getModel())) return "M";
		else if (grupocategria.getSelection().equals(rdbtnL.getModel())) return "L";
		else return "N";
	}
	
	
	public String sexo() {
		if(gruposexo.getSelection().equals(sexoH.getModel())) return "H";
		else return "M";
	}
	
	public String tiempo() {
		Date now = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formato.format(now);
	}
	
	


	
	
}
