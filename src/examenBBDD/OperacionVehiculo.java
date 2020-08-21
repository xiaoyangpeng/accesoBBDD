package examenBBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionVehiculo  {
	
	
	public  Statement tabla;
	public  ResultSet resultado;
	BBDD base;
	final String Borrar="Borrar";
	final String Inserta="Insertar";
	final String Modificar="Modificar";
	public OperacionVehiculo( BBDD base) {
		// TODO Auto-generated constructor stub
		this.base=base;
		this.tabla=base.getTabla();
		this.resultado=base.getResultado();
	}
	
	 public boolean consultarVehiculo(String Valor,String conque) {

			try {
				
				String sql=null;
				switch(conque) {
				case "conDNI":
					sql="SELECT  * FROM Vehiculo where DNI ='"+Valor+"'";
					break;
				case "conMatricula":
					sql="SELECT  * FROM Vehiculo where Matricula ='"+Valor+"'";
					break;
				}
				resultado=tabla.executeQuery(sql);
				
				if(resultado.getString("Matricula")==null) return false;
				
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
	 
	 public String consultarMatriucla(String DNI) {
		 String matriculaantes=null;
		 try {
			 String sql=null;
			 sql="SELECT  Matricula FROM Vehiculo where DNI ='"+DNI+"'";
		resultado=tabla.executeQuery(sql);
		 matriculaantes=resultado.getString("Matricula");
		 System.out.println(sql);
		 System.out.println("antessss"+matriculaantes);
		 return matriculaantes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return matriculaantes;
			
		}
		 
	 }
	 
		 public boolean accionvehiculo(String Valor,String operacion) {
			
				try {
					int ya=0;
					String sql=null;
					
					switch (operacion) {
					case "BorrarconMatricula":  
						sql="DELETE From Vehiculo  where Matricula ='"+Valor+"'";
						// antes de borrar vehiculo asi que saber de que usuario es 
						// para que luego puede borrar tabla de usuario
						consultarVehiculo(Valor,"conMatricula");
						base.DNI=resultado.getString("DNI");
						break;
					case "BorrarconDNI":
						sql="DELETE From Vehiculo  where DNI ='"+Valor+"'";
						break;
					case "Insertar":
						
					sql="insert into Vehiculo VALUES("+base.Matricula+","
					+base.Peso+","+base.Marca+","+base.Categoria+","+base.DNI+")";
								
						break;
					case "Modificar":
						
						sql="update vehiculo set Peso="+base.Peso+",Marca="
								+base.Marca+",Categoria="
								+base.Categoria+",Matricula="
								+base.Matricula+" Where DNI="+base.DNI;
						break;
					}
					
					System.out.println(sql);
					ya = tabla.executeUpdate(sql);
					
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
		 
			boolean getvehiculoBBDD()  {
				try {
					base.Matricula=resultado.getString("Matricula");
					base.Peso=resultado.getString("Peso");
					base.Categoria=resultado.getString("Categoria");
					base.Marca=resultado.getString("Marca");
					base.DNI=resultado.getString("DNI");
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			}
	
	
	
}



