package 具体列子;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class BBDD {

	public Connection conexion;
	public Statement tabla;
	public ResultSet resultado;
	
	public String DNI;
	public int Telefono;
	public String Nombre;
	public String Sexo;
	public int Edad;
	public String fehcayhora;
	
	public String Matricula;
	public String Peso;
	public String Marca;
	public String Categoria;

	



	BBDD(){
		try {
			// Asociamos el driver de SQLite
			 Class.forName("org.sqlite.JDBC");
		 conexion=DriverManager.getConnection("jdbc:sqlite:cuenta.db","","");
		 tabla=conexion.createStatement();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	
	
	
	public boolean telefono(String telefono) {
		
	
		try {
			resultado=tabla.executeQuery("SELECT  * FROM Usuario where telefono ="+telefono);
			
		if(resultado.getString("telefono")==null) return false;
				
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
		
public String telefono_DNI(String DNI) {
		
		String teleBBDD=null;
		try {
			resultado=tabla.executeQuery("SELECT  telefono FROM Usuario where DNI ='"+DNI+"'");
			
			teleBBDD=resultado.getString("telefono");
				
			return teleBBDD;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return teleBBDD;
		}
		
	}
		
	
	
	
	public void cerrar() {
		//Cerramos las conexiones de la BBDD
		 
		 try {
			 if (resultado != null) { // liberar el ResultSet si lo hemos usado
				 resultado.close();
			 }
			 
			 if (tabla != null) { // liberar los Statement
				 tabla.close();
				 }
			 
			 if (conexion != null) { // liberar la conexión a la BD
				 conexion.close();
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}
	

	public Statement getTabla() {
		return tabla;
	}




	public ResultSet getResultado() {
		return resultado;
	}
	
	public String getDNI() {
		return DNI;
	}




	public void setDNI(String dNI) {
		DNI = "'"+dNI+"'";
	}




	public int getTelefono() {
		return Telefono;
	}




	public void setTelefono(int telefono) {
		Telefono = telefono;
	}




	public String getNombre() {
		return Nombre ;
	}




	public void setNombre(String nombre) {
		Nombre = "'"+nombre+"'";
	}




	public String getSexo() {
		return Sexo;
	}




	public void setSexo(String sexo) {
		Sexo = "'"+sexo+"'";
	}




	public int getEdad() {
		return Edad;
	}




	public void setEdad(int edad) {
		Edad = edad;
	}




	public String getMatricula() {
		return Matricula;
	}




	public void setMatricula(String matricula) {
		
		Matricula ="'"+ matricula+"'";
	}




	public String getPeso() {
		return Peso;
	}




	public void setPeso(String peso) {
	
		Peso = peso;
	}




	public String getMarca() {
		
		return Marca;
	}




	public void setMarca(String marca) {
	
		Marca = "'"+marca+"'";
	}




	public String getCategoria() {
		return Categoria;
	}




	public void setCategoria(String categoria) {
		
		Categoria = "'"+categoria+"'";
	}



	public String getFehcayhora() {
		return fehcayhora;
	}



	public void setFehcayhora(String fehcayhora) {
	
			fehcayhora="'"+fehcayhora+"'";
	
		this.fehcayhora = fehcayhora;
	}


}
