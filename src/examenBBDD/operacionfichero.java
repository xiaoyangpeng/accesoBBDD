package examenBBDD;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.dnd.DragGestureEvent;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class operacionfichero {

	static String directorio=null;
	JTextField textDirectorio;
	JCheckBox chckbxVehculo;
	JCheckBox chckbxUsuario;
	JLabel Aviso ;
	final String filevehiculo="Vehiculo.txt";
	final String fileusario="Usuario.txt";
	public Statement tabla;
	public ResultSet resultado;
	JRadioButton rdbtnVehiculo;
	JRadioButton rdbtnUsuario;
	public String DNI;
	public String Telefono;
	public String Nombre;
	public String Sexo;
	public String Edad;
	public String fehcayhora;
	ButtonGroup grupo;
	public String Matricula;
	public String Peso;
	public String Marca;
	public String Categoria;
	
	public operacionfichero(JTextField textDirectorio,
	JCheckBox chckbxVehculo,
	JCheckBox chckbxUsuario,
	JLabel Aviso ,
	 Statement tabla,
	 ResultSet resultado  ,JRadioButton rdbtnVehiculo, JRadioButton rdbtnUsuario,ButtonGroup grupo) {
		this.textDirectorio=textDirectorio;
		this.chckbxVehculo=chckbxVehculo;
		this.chckbxUsuario= chckbxUsuario;
		this.Aviso=Aviso ;
		this.tabla=tabla;
		this.resultado=resultado;
		this.rdbtnVehiculo= rdbtnVehiculo;
		this.rdbtnUsuario= rdbtnUsuario;
		this.grupo=grupo;
		directorio=textDirectorio.getText();
		
	}
	
	
	void generar() {
	        	if(!existedirectorio()) {// comprobar si existe este directorio en el ordenador 
	        		Aviso.setText("NO existe este directorio en tu ordenador");
	        	}
	        	else{
	        		if(chckbxUsuario.isSelected()&&!chckbxVehculo.isSelected()) {
	
			        		if(	exportarusuario()) {
			        			Aviso.setText("El fichero de usuario ha sido exportado con exito");
			        		}else TextodeAviso.nopuedeexportar(Aviso);
						      
			        		
			        }
	        		else if(!chckbxUsuario.isSelected()&&chckbxVehculo.isSelected()) {
		        			setfile("vehiculo");
			        		if(exportarvehiuclo()){
			        			Aviso.setText("El fichero de veh¨ªculo ha sido exportado con exito");
			        		}else TextodeAviso.nopuedeexportar(Aviso);
			        		
	        		}
	        		else {
	        			if(	exportarusuario()&&exportarvehiuclo()) {
	        				Aviso.setText("Los fichero de veh¨ªculo y Usuario han sido exportado con exito");
	        			}else TextodeAviso.nopuedeexportar(Aviso);
	       	
	        		}
	        }
	}
	
	
	
	void setBBDD() {
		if(!existefile()) {
    		Aviso.setText("NO existe este fichero en tu ordenador");
    	}
		else {
			if(rdbtnUsuario.isSelected()) 
			{
				
					if(importarusuario())	{
							importarusuario();
							Aviso.setText("<html><body>Usuario ha importado con existo<br>"
									+ "Ahora debes importar sus veh¨ªculos</html></body>");
					}else TextodeAviso.nopuedeimportar(Aviso);
			}
			else  if(rdbtnVehiculo.isSelected()) {
				
							if(importarvehiculo()){
							Aviso.setText("Vehiculos ha importado con existo.");
							} else TextodeAviso.nopuedeimportar(Aviso);
			}
			else Aviso.setText("Error ");
		}
	}
	
	void setfile(String que){
		File fichero=new File(directorio);
		if(que.equals("usuario")) 	directorio=textDirectorio.getText()+fichero.separator+fileusario;
		else 	directorio=textDirectorio.getText()+fichero.separator+filevehiculo;
		
	}
	
	 boolean existedirectorio() {
		File fichero=new File(directorio);
		return fichero.isDirectory();
	}
	
	 
	 boolean existefile() {
			File fichero=new File(directorio);
			return fichero.isFile();
		}
	 
	 
	boolean exportarusuario() {
		setfile("usuario");
	        try {
	        	
	        	BufferedWriter	fichero = new  BufferedWriter(new FileWriter(directorio));
	        	resultado=tabla.executeQuery("SELECT  * FROM Usuario ");
	        	while(resultado.next()) {
	        		DNI=resultado.getString("DNI");
					Nombre=resultado.getString("Nombre");
					Edad=resultado.getString("Edad");
					fehcayhora=resultado.getString("fecha_hora_registrar");
					Sexo=resultado.getString("Sexo");
					Telefono=resultado.getString("Telefono");
					fichero.write(DNI+" "+Telefono+" "+Nombre+" "+Sexo+" "+Edad + " "+fehcayhora);
					fichero.newLine();
	        	}
	            fichero.flush();
	            fichero.close();  
	            return true;
	        } catch (IOException e) {
	        	Aviso.setText("Fallo en este directorio");
	        	return false;
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				TextodeAviso.ErrorenBBDD(Aviso);
				return false;
			} 
	}

	boolean exportarvehiuclo() {// tipo puede ser fijo, que es el metodo contenidofijo
		setfile("vehiculo");								//o variable 
	        try {
	        	
	        	BufferedWriter	fichero = new  BufferedWriter(new FileWriter(directorio));
	        	resultado=tabla.executeQuery("SELECT  * FROM Vehiculo ");
	        	while(resultado.next()) {
	        		Matricula=resultado.getString("Matricula");
	        		Peso=resultado.getString("Peso");
					Categoria=resultado.getString("Categoria");
					Marca=resultado.getString("Marca");
					DNI=resultado.getString("DNI");
					fichero.write(Matricula+" "+Peso+" "+Marca+" "+Categoria+" "+DNI);
					fichero.newLine();
	        	}
	            fichero.flush();
	            fichero.close();  
	            return true;
	        } catch (IOException e) {
	        	return false;
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			} 
	}
	
boolean importarusuario() {
	
		try {
				FileReader entrada=new FileReader(directorio);
				BufferedReader buffered=new BufferedReader(entrada);
				String frace="";
				
				while(frace!=null) {
					frace=buffered.readLine();
					 System.out.println(frace);
					if(frace!=null) {
					 int primero=frace.indexOf(" ");
					 int segundo=frace.indexOf(" ",primero+1);
					 int tercero=frace.indexOf(" ",segundo+1);
					 int cuarto=frace.indexOf(" ",tercero+1);
					 int quinto=frace.indexOf(" ",cuarto+1);
					 
					 DNI=frace.substring(0,primero);
					 Telefono=frace.substring(primero+1,segundo);
					 Nombre=frace.substring(segundo+1,tercero);
					 Sexo=frace.substring(tercero+1,cuarto);
					 Edad=frace.substring(cuarto+1,quinto);
					 fehcayhora=frace.substring(quinto+1);
					 
					String sql="insert into Usuario VALUES('"+DNI+"',"+Telefono+",'"+Nombre+"','"+Sexo+"',"+Edad+",'"+fehcayhora+"')";
					tabla.executeUpdate(sql);
						}
				}
				buffered.close();
			return true;
			
		} 
		catch (NullPointerException |StringIndexOutOfBoundsException e) {
			return false;
		}catch (IOException e) {
			Aviso.setText("Fallo en este directorio");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			TextodeAviso.ErrorenBBDD(Aviso);
			return false;
		}
		
	}
	


boolean importarvehiculo() {
	
					try {
							FileReader entrada=new FileReader(directorio);
						
							BufferedReader buffered=new BufferedReader(entrada);
							String frace=" ";
							
							while(frace!=null) {
									frace=buffered.readLine();
									if(frace!=null) {
									 int primero=frace.indexOf(" ");
									 int segundo=frace.indexOf(" ",primero+1);
									 int tercero=frace.indexOf(" ",segundo+1);
									 int cuarto=frace.indexOf(" ",tercero+1);
									 Matricula=frace.substring(0,primero);
									Peso=frace.substring(primero+1,segundo);
									 Marca=frace.substring(segundo+1,tercero);
									 Categoria=frace.substring(tercero+1,cuarto);
									 DNI=frace.substring(cuarto+1);
									String sql="insert into Vehiculo VALUES('"+Matricula+"',"+Peso+",'"+Marca+"','"+Categoria+"','"+DNI+"')";
									tabla.executeUpdate(sql);
							
									}
							}
							buffered.close();
						return true;
					}
					catch (NullPointerException |StringIndexOutOfBoundsException e) {
						return false;
					}catch (IOException e) {
						return false;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						return false;
					}
					
			}
	
	
}
