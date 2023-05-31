import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc_2_fetch {

	public static void main(String[] args) throws SQLException {
// To fetch the data from data base
		Connection connection=null;
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from student");
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2));
				
			}
		}
		finally {
			connection.close();
		}
	}

}
