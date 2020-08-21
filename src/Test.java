
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
        	 // 首先需要每个base de datos 的jdbc jar文件，导入这个proyecto里面
        	 
        	 
         // Class.forName(driverName);
        	 
        	 //1:连接
           Connection conexion=DriverManager.getConnection(dbURL,userName,userPwd);
 
         
          //
           Statement table=conexion.createStatement();
           //不可以滚动
           // 这样子等下ResultSet他起到的作用就是完成了查询结果的存储功能，而且只能读去一次，不能够来回的滚动读取
           
    
           
           /**  // 可以滚动型
           //  Statement st = conn. createStatement (int resultSetType, int resultSetConcurrency) ;
             　resultSetType 是设置 ResultSet 对象的类型可滚动，或者是不可滚动。取值如下： 
     　　　　ResultSet.TYPE_FORWARD_ONLY 只能向前滚动 
     　　　　ResultSet.TYPE_SCROLL_INSENSITIVE 和 Result.TYPE_SCROLL_SENSITIVE 这两个方法都能够实现任意的前后滚动，使用各种移动的 ResultSet 指针的方法。二者的区别在于前者对于修改不敏感，而后者对于修改敏感。 


     　　resultSetConcurency 是设置 ResultSet 对象能够修改的，取值如下： 
     　　　　ResultSet.CONCUR_READ_ONLY 设置为只读类型的参数。 
     　　　　ResultSet.CONCUR_UPDATABLE 设置为可修改类型的参数。 
             
             */
           
          
           
         /*  1，boolean execute 允许执行查询语句、更新语句、DDL语句
           	返回值为true时，表示执行的是查询语句，可以通过getResultSet方法获取结果；返回值为false时，执行的是更新语句或DDL语句。
           	
           2，getUpdateCount方法 获取更新的记录数量。
           
           3，int executeUpdate(String sql)执行给定 SQL 语句
           	该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）。 
           	
           4，ResultSet executeQuery(String sql) 执行给定的 SQL 语句
           	该语句返回单个 ResultSet 对象。返回值是更新的记录数量。
           */
           
           //  ResultSet 封装了结果集的对象：内部有一个可移动的光标，默认情况，指向第一条记录集的上一条记录：就是空白处，要指向
         
           //下一行必须用next（）
           
  
        ResultSet resu=table.executeQuery("SELECT * FROM JAJA");
        resu.next();//如果下一行还有就返回true，否则返回false
  
        
        while(resu.next()) {//这样子我们就可以一直重复这个表格全部的内容
        	System.out.println(resu.getString(2));
        }
        
        
        
        
        
        //getString(),可以用列名或者列在第几列的数字
       System.out.println(resu.getString(2));
    
       
       //还可以直接getint，date 等等
     /*  System.out.println(resultado.getInt("CODIGO") + " "
    		   + resultado.getString("NOMBRE") + " "
    		   + resultado.getDate("FECALTA") + " "
    		   + resultado.getDouble("SUELDO"));
       */
       
        /*
						         * 在滚动结果集中可用的方法有：         
						
						rs.previous();//向前滚动         
						
						rs.next();//向后滚动         
						
						rs.getRow();//得到当前行号         
						
						rs.absolute(n);//光标定位到n行         
						
						rs.relative(int   n);//相对移动n行         
						
						rs.first();//将光标定位到结果集中第一行。         
						
						rs.last();//将光标定位到结果集中最后一行。         
						
						rs.beforeFirst()//将光标定位到结果集中第一行之前。         
						
						rs.afterLast();//将光标定位到结果集中最后一行之后。         
						
						rs.moveToInsertRow()；//光标移到插入行         
						
						rs.moveToCurrentRow();//光标移回到调用 
						
						rs.moveToInsertRow()方法前光标所在行         
						
						//测试光标位置         
						
						rs.isFirst()         
						
						rs.isLast()         
						
						rs.isBeforeFirst()         
						
						rs.isAfterLast()         
						
						在可更新结果集中可用的方法有：(单表)         
						
						rs.insertRow();//把插入行加入数据库和结果集         
						
						rs.deleteRow();//从数据库和结果集中删除当前行         
						
						rs.updateXXX(int   column,XXX   data);XXX代表int/double/String/Date中类型之一  
						
						rs.updateXXX(String   columnName,String   Data);    //以上两个方法更新结果集当前行         
						
						rs.updateRow();//更新内容发送到更新数据库
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

public void cerrar() {//我们要创造一个方法，用来关闭BBDD。
	// 我们需要关闭BBDD 每当我们用完之后，就是说拆入内容到BBDD 之后或者读取BBDD里的数据之后
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
} 
