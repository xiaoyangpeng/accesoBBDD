package examenBBDD;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Comprobar {

	
	
	
	static boolean vacio_usario(String DNI,JLabel Aviso) {
		if(DNI.equals("")) {
			Aviso.setText("Campo usuario est¨¢ vac¨ªo");
			return false;
		}
		else return true;
	}
	
	
	static boolean vacio_vehiculo(String Matricula,JLabel Aviso) {
		if(Matricula.equals("")) {
			Aviso.setText("Campo Veh¨ªculo est¨¢ vac¨ªo");
			return false;
		}	
		return true;
	}
	

	static boolean Telefono(BBDD base,String telefono,JLabel Aviso)
	{
	
		if(!numero(telefono)||((telefono.length()>9)||(telefono.length()<9)))
		{Aviso.setText("<html><body>El Telefono no puede<br> "
		 		+ "tener letras , ni m¨¢s <br>"
		 		+ "ni menos de 9 cifras</html></body>");
		return false;
		}
		
		 return true;
			 	
	}
	


	static boolean DNI(String DNI,JLabel Aviso) {
		if(DNI.length()>9 || DNI.length()<9) {
			TextodeAviso.ErrorDNI(Aviso);
			return false;
		}
		if(!numero(DNI.substring(1,8))) {
			TextodeAviso.ErrorDNI(Aviso);
			return false;
		}
		if(!letra(DNI.substring(8,9))) {
			TextodeAviso.ErrorDNI(Aviso);
			return false;
		}
		if(!digito_control.estabien(DNI)) {
			Aviso.setText("DNI/NIE incorrecto");
			return false;
		}
		
		return true;
	}
	
	
	static boolean Edad(String Edad,JLabel Aviso) {
		
		if(!numero(Edad)) {
			 Aviso.setText("<html><body>El valo de Edad no puede"
				 		+ " tener letras</html></body>");
				 return false;
				 }
		
		if((Integer.parseInt(Edad))>99 ||(Integer.parseInt(Edad))<16)
		{Aviso.setText("<html><body>Edad no puede<br> "
		 		+ "ser menos que 16 <br>"
		 		+ "ni m¨¢s que 99 </html></body>");
		return false;
		}
		
		 return true;
	}
	
	
	static boolean peso(String peso,JLabel Aviso) {
		
		if(!numero(peso)) {
			Aviso.setText("Peso no pueder ser con letra");
			return false;
		}
		return true;
	}
	 static boolean Matricula(String Matricula,JLabel Aviso) {
		 
		 if(Matricula.length()>7 || Matricula.length()<7) {
				TextodeAviso.ErrorMatricula(Aviso);
				return false;
			}
			if(!numero(Matricula.substring(0,4))) {
				TextodeAviso.ErrorMatricula(Aviso);
				return false;
			}
			if(!letra(Matricula.substring(4,7))) {
				TextodeAviso.ErrorMatricula(Aviso);
				return false;
			}
			return true;
		 
	 }
	static boolean numero(String valor) {
		
		for(int i=0;i<valor.length();i++) { 
			
			char cada=valor.charAt(i);
		
			if((cada<48)||(cada>57)) return false;// en  ASCII 0=48  9=57
			
		}
		return true;
	}
	
	static boolean letra(String valor) {
		
		for(int i=0;i<valor.length();i++) { 
			char cada=valor.charAt(i);
		
			if((cada<65)||(cada>122)) return false;// en  ASCII A=65  Z=90
			if((cada>90&&cada<97))	 return false;	// a=97  z=122
			
		}
		return true;
	}

}
