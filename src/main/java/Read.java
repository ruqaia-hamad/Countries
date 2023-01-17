import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Read {
	public static void read() throws IOException, InterruptedException {

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

			try {

				System.out.println("common:" + x.getName().getCommon());
				System.out.println("official:" + x.getName().getOfficial());
				System.out.println((x.getName().getNativeName().getEng() != null)
						? x.getName().getNativeName().getEng().getOfficial()
						: "Eng official object is null");

				System.out.println((x.getName().getNativeName().getEng() != null)
						? x.getName().getNativeName().getEng().getCommon()
						: "Eng common object is null");
				System.out.println("TLD:" + x.getTld()[0]);
				System.out.println("Cca2:" + x.getCca2());
				System.out.println("ccn3:" + x.getCcn3());
				System.out.println("cca3:" + x.getCca3());
				System.out.println("cioc:" + x.getCioc());
				System.out.println("independent:" + x.isIndependent());
				System.out.println("status:" + x.getStatus());
				System.out.println("unMember:" + x.isUnMember());
				System.out.println("root:" + x.getIdd().getRoot());
				System.out.println("Suffixes:" + x.getIdd().getSuffixes()[0]);
				System.out.println("Capital:" + x.getCapital()[0]);
				System.out.println("altSpellings:" + x.getAltSpellings()[0]);
				System.out.println("region:" + x.getRegion());
				System.out.println("subregion:" + x.getSubregion());
				System.out.println("languages:" + x.getLanguages().getEng());
				System.out.println("landlocked:" + x.isLandlocked());
				System.out.println("area:" + x.getArea());
				System.out.println("F:" + x.getDemonyms().getEng().getF());
				System.out.println("M:" + x.getDemonyms().getEng().getM());
				System.out.println("Flag:" + x.getFlag());
				System.out.println("PNG:" + x.getFlags().getPng());
				System.out.println("SVG:" + x.getFlags().getSvg());
				System.out.println("googleMaps:" + x.getMaps().getGoogleMaps());
				System.out.println("OpenStreetMaps:" + x.getMaps().getOpenStreetMaps());
				System.out.println("population:" + x.getPopulation());
				System.out.println("fifa:" + x.getFifa());
				if (x.getCar().getSigns() != null) {
					System.out.println("signs" + x.getCar().getSigns()[0]);
				} else {
					System.out.println("signs :null");
				}
				System.out.println("timezones:" + x.getTimezones()[0]);
				System.out.println("continents:" + x.getContinents()[0]);
				System.out.println("coatOfArms PNG :" + x.getCoatOfArms().getPng());
				System.out.println("coatOfArms SVG :" + x.getCoatOfArms().getSvg());
				System.out.println("startOfWeek :" + x.getStartOfWeek());
				System.out.println("latlng :" + x.getCapitalInfo().getLatlng()[0]);

			} catch (Exception ex) {

				System.out.println(ex);
			}
		}
	
	}

}
