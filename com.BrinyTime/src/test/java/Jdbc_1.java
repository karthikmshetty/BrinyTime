import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc_1 {

	public static void main(String[] args) throws SQLException {

		//Insert or update data to data base.
		Connection connection=null;
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
             Statement statement = connection.createStatement();	
             String Query="insert into student values('103','abc')";
             int result = statement.executeUpdate(Query);
			if(result==1)
			{
				System.out.println("Data updated in database ");
			}
			else
				System.out.println("Data not updated");
		}
		
		finally {
			connection.close();
			}
		
		}
}
