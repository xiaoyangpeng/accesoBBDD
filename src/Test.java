
import java.util.Scanner;
import java.sql.*;

public class Test  {
	
public static void main(String[] args) {

        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        String dbURL="jdbc:sqlserver://ANTONIO;DatabaseName=VUREAVITEST";
        String userName="sa";
        String userPwd="123";
         try
       {
        	 // ������Ҫÿ��base de datos ��jdbc jar�ļ����������proyecto����
        	 
        	 
         // Class.forName(driverName);
        	 
        	 //1:����
           Connection conexion=DriverManager.getConnection(dbURL,userName,userPwd);
 
         
          //
           Statement table=conexion.createStatement();
           //�����Թ���
           // �����ӵ���ResultSet���𵽵����þ�������˲�ѯ����Ĵ洢���ܣ�����ֻ�ܶ�ȥһ�Σ����ܹ����صĹ�����ȡ
           
    
           
           /**  // ���Թ�����
           //  Statement st = conn. createStatement (int resultSetType, int resultSetConcurrency) ;
             ��resultSetType ������ ResultSet ��������Ϳɹ����������ǲ��ɹ�����ȡֵ���£� 
     ��������ResultSet.TYPE_FORWARD_ONLY ֻ����ǰ���� 
     ��������ResultSet.TYPE_SCROLL_INSENSITIVE �� Result.TYPE_SCROLL_SENSITIVE �������������ܹ�ʵ�������ǰ�������ʹ�ø����ƶ��� ResultSet ָ��ķ��������ߵ���������ǰ�߶����޸Ĳ����У������߶����޸����С� 


     ����resultSetConcurency ������ ResultSet �����ܹ��޸ĵģ�ȡֵ���£� 
     ��������ResultSet.CONCUR_READ_ONLY ����Ϊֻ�����͵Ĳ����� 
     ��������ResultSet.CONCUR_UPDATABLE ����Ϊ���޸����͵Ĳ����� 
             
             */
           
          
           
         /*  1��boolean execute ����ִ�в�ѯ��䡢������䡢DDL���
           	����ֵΪtrueʱ����ʾִ�е��ǲ�ѯ��䣬����ͨ��getResultSet������ȡ���������ֵΪfalseʱ��ִ�е��Ǹ�������DDL��䡣
           	
           2��getUpdateCount���� ��ȡ���µļ�¼������
           
           3��int executeUpdate(String sql)ִ�и��� SQL ���
           	��������Ϊ INSERT��UPDATE �� DELETE ��䣬���߲������κ����ݵ� SQL ��䣨�� SQL DDL ��䣩�� 
           	
           4��ResultSet executeQuery(String sql) ִ�и����� SQL ���
           	����䷵�ص��� ResultSet ���󡣷���ֵ�Ǹ��µļ�¼������
           */
           
           //  ResultSet ��װ�˽�����Ķ����ڲ���һ�����ƶ��Ĺ�꣬Ĭ�������ָ���һ����¼������һ����¼�����ǿհ״���Ҫָ��
         
           //��һ�б�����next����
           
  
        ResultSet resu=table.executeQuery("SELECT * FROM JAJA");
        resu.next();//�����һ�л��оͷ���true�����򷵻�false
  
        
        while(resu.next()) {//���������ǾͿ���һֱ�ظ�������ȫ��������
        	System.out.println(resu.getString(2));
        }
        
        
        
        
        
        //getString(),�����������������ڵڼ��е�����
       System.out.println(resu.getString(2));
    
       
       //������ֱ��getint��date �ȵ�
     /*  System.out.println(resultado.getInt("CODIGO") + " "
    		   + resultado.getString("NOMBRE") + " "
    		   + resultado.getDate("FECALTA") + " "
    		   + resultado.getDouble("SUELDO"));
       */
       
        /*
						         * �ڹ���������п��õķ����У�         
						
						rs.previous();//��ǰ����         
						
						rs.next();//������         
						
						rs.getRow();//�õ���ǰ�к�         
						
						rs.absolute(n);//��궨λ��n��         
						
						rs.relative(int   n);//����ƶ�n��         
						
						rs.first();//����궨λ��������е�һ�С�         
						
						rs.last();//����궨λ������������һ�С�         
						
						rs.beforeFirst()//����궨λ��������е�һ��֮ǰ��         
						
						rs.afterLast();//����궨λ������������һ��֮��         
						
						rs.moveToInsertRow()��//����Ƶ�������         
						
						rs.moveToCurrentRow();//����ƻص����� 
						
						rs.moveToInsertRow()����ǰ���������         
						
						//���Թ��λ��         
						
						rs.isFirst()         
						
						rs.isLast()         
						
						rs.isBeforeFirst()         
						
						rs.isAfterLast()         
						
						�ڿɸ��½�����п��õķ����У�(����)         
						
						rs.insertRow();//�Ѳ����м������ݿ�ͽ����         
						
						rs.deleteRow();//�����ݿ�ͽ������ɾ����ǰ��         
						
						rs.updateXXX(int   column,XXX   data);XXX����int/double/String/Date������֮һ  
						
						rs.updateXXX(String   columnName,String   Data);    //���������������½������ǰ��         
						
						rs.updateRow();//�������ݷ��͵��������ݿ�
						         */
						        
						     
     /*   while(resu.next()) {
        	System.out.println(resu.getString("origen"));
        }*/
           
        }
         catch(Exception e)
      {
           e.printStackTrace();
           System.out.print("fail!");
      }
   }



ResultSet resultado;
Statement tabla;
Connection conexion;

public void cerrar() {//����Ҫ����һ�������������ر�BBDD��
	// ������Ҫ�ر�BBDD ÿ����������֮�󣬾���˵�������ݵ�BBDD ֮����߶�ȡBBDD�������֮��
	//Cerramos las conexiones de la BBDD
	 
	 try {
		 if (resultado != null) { // liberar el ResultSet si lo hemos usado
			 resultado.close();
		 }
		 
		 if (tabla != null) { // liberar los Statement
			 tabla.close();
			 }
		 
		 if (conexion != null) { // liberar la conexi��n a la BD
			 conexion.close();
			 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	
}
} 
