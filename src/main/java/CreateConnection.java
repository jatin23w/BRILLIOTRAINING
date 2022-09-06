
//import java.sql.Connection;
import java.sql.*;

public class CreateConnection {
	static String url = "jdbc:mysql://localhost/aliensdata";
	static String uname = "root";
	static String pass = "root";
	public static Connection connection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = (Connection) DriverManager.getConnection(url, uname, pass);
		return con;
	}
}
