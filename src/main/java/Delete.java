import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=Countries;encrypt=true;trustServerCertificate=true";
	static String user = "sa";
	static String pass = "root";
	public static void deleteById()
			throws IOException, InterruptedException, InstantiationException, Throwable, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);

		Connection con = null;
		Statement stmt = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			System.out.print("Enter the id to be deleted : ");
			int id = sc.nextInt();
			String sql = "DELETE FROM users WHERE id = " + id;
			stmt = con.createStatement();
			stmt.executeUpdate(sql);

			System.out.println("Record deleted successfully");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
