package DDTPractice;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCInsert {

	public static void main(String[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
		//Driver driver = new Driver();
		//DriverManager.registerDriver(driver);
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","rootroot");
		 Statement state = conn.createStatement();
		 String query ="Insert into trainers (firstName,lastName,address)VALUES('DFFDF','DFDR','DFTT')";
		 int result = state.executeUpdate(query);
		 if(result == 1)
		 {
			 System.out.println("insert successfull");
		 }
		 else
		 {
			 System.out.println("insert is not successfull");
		 }
		 
		 conn.close();
	}

}
