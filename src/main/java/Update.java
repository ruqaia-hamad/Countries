import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=Countries;encrypt=true;trustServerCertificate=true";
	static String user = "sa";
	static String pass = "root";
	public static void update() throws Throwable {

		String sql = "UPDATE country SET cca2  = ?, ccn3 = ?,cca3 = ?,region = ?, subregion = ? WHERE id = ?";

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id of the row to update: ");
		int id = sc.nextInt();
		System.out.print("Enter cca2 to update: ");
		String cca2_update = sc.next();
		System.out.print("Enter ccn3 to update: ");
		String ccn3_update = sc.next();
		System.out.print("Enter cca3 to update: ");
		String cca3_update = sc.next();
		System.out.print("Enter region to update: ");
		String region_update = sc.next();
		System.out.print("Enter subregion to update: ");
		String subregion_update = sc.next();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1,cca2_update);
			pstmt.setString(2,ccn3_update);
			pstmt.setString(3,cca3_update );
			pstmt.setString(4,region_update);
			pstmt.setString(5,subregion_update);
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
			String sql2 = "SELECT * FROM country WHERE id = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, id);
			ResultSet rs = pstmt2.executeQuery();

			if (rs.next()) {
				String cca2 =rs.getString("cca2");
				String ccn3 =rs.getString("ccn3");
				String cca3 =rs.getString("cca3");
				String region =rs.getString("region");
				String subregion =rs.getString("subregion");
				String fifa =rs.getString("fifa");
				System.out.println(id + "\n" + cca2 + "\n " + ccn3 + "\n " + cca3 + "\n "+ region + "\n " + subregion + "\n" + fifa);

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
