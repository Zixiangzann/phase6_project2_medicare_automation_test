package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlQueryFunction {
	
	public static int getCount(String sqlQuery) throws ClassNotFoundException, SQLException {
		  Class.forName("com.mysql.jdbc.Driver");
	      String myUrl = "jdbc:mysql://localhost/medicare";
	      Connection conn = DriverManager.getConnection(myUrl, "mediadmin", "Minions@123");
	      
	      String query = sqlQuery;
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      rs.next();
	      int count = rs.getInt(1);
	      return count;

	}

}
