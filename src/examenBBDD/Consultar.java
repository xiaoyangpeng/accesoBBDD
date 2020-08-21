package examenBBDD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Consultar  {

	private String DNI;
	private String Matricula;
	private String Peso;
	private String Marca;
	private String Categoria;
	  JTextField textDNI;
      JTextField textNombre;
     JTextField textTelefono;
     JTextField textEdad;
	 JTextField textFechaYHora;
	 JLabel Aviso;
	 JTextField textUsuario;
	 JTextField textVehiculo;
	JButton btnmodificar;
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
	
	public Consultar(JTextField textDNI,
    JTextField textNombre,
   JTextField textTelefono,
   JTextField textEdad,
	 JTextField textFechaYHora,
	 JLabel Aviso,
	 JTextField textUsuario,
	 JTextField textVehiculo,
	JButton btnmodificar,
	JTextField textMatricula,
	JTextField textPeso,
	JTextField textMarca,
	JRadioButton sexoH,
	JRadioButton sexoM ,
	JRadioButton rdbtnL ,
	JRadioButton rdbM  ,
	JRadioButton rdbtnN ,
	JRadioButton rdbtnUsuario,
	JRadioButton rdbtnVechiculo,
	ButtonGroup grupousuariovehiculo){
		 this.textDNI=textDNI;
	     this.textNombre=textNombre;
	    this.textTelefono= textTelefono;
	     this.textEdad= textEdad;
		 this.textFechaYHora= textFechaYHora;
		this.Aviso= Aviso;
		this.textUsuario = textUsuario;
		 this.textVehiculo= textVehiculo;
		this.btnmodificar = btnmodificar;
		this.textMatricula = textMatricula;
		this.textPeso=textPeso;
		this.textMarca =textMarca;
		this.sexoH =sexoH;
		this.sexoM=sexoM ;
		this.rdbtnL= rdbtnL ;
		this.rdbM = rdbM  ;
		this.rdbtnN=rdbtnN ;
		this.rdbtnUsuario=rdbtnUsuario;
		this.rdbtnVechiculo= rdbtnVechiculo;
		this.grupousuariovehiculo= grupousuariovehiculo;
	
	}
	
	
	public void BotonConsultar() {
		
				BBDD base=new BBDD();
				OperacionVehiculo opevehiculo=new OperacionVehiculo(base);
				Operacion_usuario opeusuario=new Operacion_usuario(base);
				ButtonModel cual=grupousuariovehiculo.getSelection();// ver que JRadioButton ha elegido
			//	vaciar();
				if(cual.equals(rdbtnUsuario.getModel())) {
					DNI=textUsuario.getText();
				if(Comprobar.vacio_usario(DNI, Aviso)) {
						if(opeusuario.consultarUsuario(DNI)) {
							if(opeusuario.getUsuarioBBDD()&&opevehiculo.consultarVehiculo(DNI, "conDNI")&&opevehiculo.getvehiculoBBDD( )) 
							{
							 darUsuario(base);
							 darvehiculo(base);
							 btnmodificar.setEnabled(true);
					
							}
							else TextodeAviso.ErrorenBBDD(Aviso);
						}
						else {
							TextodeAviso.UsuarioNoexiste(DNI, Aviso);
						}
					}
				}// elegir Usuario
				else if(cual.equals(rdbtnVechiculo.getModel())) {
	
					Matricula=textVehiculo.getText();
					
					if(Comprobar.vacio_vehiculo(Matricula, Aviso)) {
							  if(opevehiculo.consultarVehiculo(Matricula, "conMatricula")&&opevehiculo.getvehiculoBBDD( )) {
								 if(opeusuario.consultarUsuario(base.getDNI())&&opeusuario.getUsuarioBBDD())
								 {
									 darvehiculo(base);
								     darUsuario(base);
								     btnmodificar.setEnabled(true);
								 }else TextodeAviso.ErrorenBBDD(Aviso);
							  }	
							  else TextodeAviso.Matricanoexiste(Matricula,Aviso);	   
						}
				}
			
			base.cerrar();
		}
			

	public void darvehiculo(BBDD base) {
		
			Categoria=base.getCategoria();
			textMatricula.setText(base.getMatricula());
			textPeso.setText(base.getPeso());
			textMarca.setText(base.getMarca());

			if(Categoria.equals("M")) rdbM.setSelected(true);
			else if (Categoria.equals("L")) rdbtnL.setSelected(true);
			else rdbtnL.setSelected(true);
		
	}
	
	public void darUsuario(BBDD base) {
		textNombre.setText(base.getNombre());
		textEdad.setText(Integer.toString(base.getEdad()));
		textFechaYHora.setText(base.getFehcayhora());
		
		if(base.getSexo().equals("H")) sexoH.setSelected(true);
		else sexoM.setSelected(true);
		
		textTelefono.setText(Integer.toString(base.getTelefono()));
		
		textDNI.setText(base.getDNI());// este sirve para tomar referencia en accion de modificar
		// porque campo de DNI (el de abajo) no permite tocar
		
	}
	
}
