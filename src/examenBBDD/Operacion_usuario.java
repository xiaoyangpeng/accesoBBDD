package examenBBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operacion_usuario {
	
	public  Statement tabla;
	public  ResultSet resultado;
	BBDD base;
	public Operacion_usuario(BBDD base) {
		
		// TODO Auto-generated constructor stub
		this.base=base;
		this.tabla=base.getTabla();
		this.resultado=base.getResultado();
	}
	
public boolean consultarUsuario(String DNI) {
		
		try {
			resultado=tabla.executeQuery("SELECT  * FROM Usuario where DNI ='"+DNI+"'");
			base.DNI=resultado.getString("DNI");
			if (base.DNI==null) return false;
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;  
		}
		 
	}


public boolean  AccionUsuario(String DNI,String operacion) {

		try {
					String sql=null;	
					switch (operacion) {
							case "Borrar":
								sql="DELETE From Usuario where DNI ='"+base.DNI+"'";
								break;
							case "Insertar":
								sql="insert into Usuario VALUES("+base.DNI+","+base.Telefono+","+base.Nombre+","+base.Sexo+","+base.Edad+","+base.fehcayhora+")";
								System.out.println(sql);
								break;
							case "Modificar":
								sql="update Usuario set telefono="+base.Telefono+",nombre="
							+base.Nombre+",Sexo="
							+base.Sexo+",Edad="
							+base.Edad+" Where DNI="+base.DNI;
								break;
					}
					

					int ya=tabla.executeUpdate(sql);
					// cuando ha borrado con exito tabla.executeUpdate devuelve 1
		
					if(ya==1) {
						return true;
					}
					else {
						return false;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
}



		boolean getUsuarioBBDD() {
			try {
				base.DNI=resultado.getString("DNI");
				base.Nombre=resultado.getString("Nombre");
				base.Edad=resultado.getInt("Edad");
				base.fehcayhora=resultado.getString("fecha_hora_registrar");
				base.Sexo=resultado.getString("Sexo");
				base.Telefono=resultado.getInt("Telefono");
				return true;
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	
}

}
