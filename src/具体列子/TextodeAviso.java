package 具体列子;
import javax.swing.JLabel;

public class TextodeAviso {

	
	
	static public void Matricanoexiste(String Matricula,JLabel Aviso) {
		 Aviso.setText(
					"<html><body>No existe Matrícula: <br>"
					+ ""+Matricula+ "<br>"
					+ " en BBDD"
					+ "</html></body>");
	}
	
	
	static public void UsuarioNoexiste(String DNI,JLabel Aviso) {
		
		 Aviso.setText("<html><body>No existe DNI: <br>"
					+ ""+DNI+ "<br>"
					+ " en BBDD"
					+ "</html></body>");
	}
	static public void Matricayaexiste(String Matricula,JLabel Aviso) {
		 Aviso.setText(
					"<html><body>Ya existe Matrícula: <br>"
					+ ""+Matricula+ "<br>"
					+ " en BBDD"
					+ "</html></body>");
	}
	
	
	static public void Usuarioyaexiste(String DNI,JLabel Aviso) {
		
		 Aviso.setText("<html><body>Ya existe DNI: <br>"
					+ ""+DNI+ "<br>"
					+ " en BBDD"
					+ "</html></body>");
	}
	
	static public void Borradoexito(JLabel Aviso) {
		
		Aviso.setText("<html><body>Ya ha borrado el usuario<br>"
				+ " y su vehículo"
				+ "</html></body>");
	}
	
	static public void Borrarfracasado(JLabel Aviso) {
		Aviso.setText("<html><body>No se puede borrar el usuario<br>"
					+ " hay otro fallo desconocido en BBDD</html></body>");
	}
	
	static public void ErrorenBBDD(JLabel Aviso) {
		Aviso.setText("<html><body>Hay error en BBDD</html></body>");
	}
	static public void ErrorDNI(JLabel Aviso) {
		Aviso.setText("<html><body>DNI Incorrecto <br> "
		 		+"Hay que tener 7/6 números <br>"
		 		+ "y 1/2 letra"+
				"</html></body>");
	
	}
	
	static public void ErrorMatricula(JLabel Aviso) {
		Aviso.setText("<html><body>Matricula Incorrecto <br> "
		 		+"Hay que tener 4 números <br>"
		 		+ "y 3  letra detrás"+
				"</html></body>");
	
	}
	
	static public void Directoriovacio(JLabel Aviso) {
		Aviso.setText("El direcotrio esta vacío");
	}
	
	static public void limpia(JLabel Aviso) {
		Aviso.setText("Aviso");
	}
	static public void Hayqueelegirusario(JLabel Aviso) {
		Aviso.setText("<html><body>Para insertar es <br> "
		 		+"Obligatoriamente con <br>"
		 		+ "DNI de usuario"+
				"</html></body>");
	}
	
	static public void yaexistelefono(JLabel Aviso) {
		Aviso.setText("Ya existe este telefono");
	}
	static public void nopuedeimportar(JLabel Aviso) {
		Aviso.setText("<html><body>No se puede importar al BBDD <br>"
				+ " Hay error en BBDD o en este fichero</html></body>");
	}
	
	static public void nopuedeexportar(JLabel Aviso) {
		
		Aviso.setText("<html><body>No se puede exportar a este directorio <br>"
				+ " Hay error en BBDD o en este directorio</html></body>");
	}
}
