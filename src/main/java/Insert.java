import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Insert {
	static String url = "jdbc:sqlserver://localhost:1433;databaseName=Countries;encrypt=true;trustServerCertificate=true";
	static String user = "sa";
	static String pass = "root";

	public static void insert() throws IOException, InterruptedException {

		String jsonUrl = "https://restcountries.com/v3.1/all";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	System.out.println(response.body());
		String responsee = response.body();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responsee);
		String prettyJsonString = gson.toJson(je);
//	System.out.println(prettyJsonString);
		Country[] attributs = gson.fromJson(prettyJsonString, Country[].class);
 
		for (Country x : attributs) {

			String cca2 = x.getCca2();
			String ccn3 = x.getCcn3();
			String cca3 = x.getCca3();
			String cioc = x.getCioc();
			String region = x.getRegion();
			String subregion = x.getSubregion();
			String fifa = x.getFifa();
			 
			String sql = "insert into country(cca2,ccn3,cca3, cioc,region,subregion,fifa)"
					+ " values('" + cca2 + "', '" + ccn3 + "','" + cca3 + "' ,' "
					+ cioc + "','" + region + "','" +subregion + "','" +fifa+"')";
			Connection con = null;
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();

				int m = st.executeUpdate(sql);
				if (m >= 0)
					System.out.println("inserted successfully ");
				else
					System.out.println("insertion failed");

				con.close();
			} catch (Exception ex) {

				System.out.println(ex);
			}
		}
	}


}
