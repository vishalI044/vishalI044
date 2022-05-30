package First;

import java.io.BufferedReader;
import java.net.*;
import java.util.*;

import org.json.*;


public class Api {

	    public static void main(String[] args) {

	        try {
	            //Public API:
	            //https://www.metaweather.com/api/location/search/?query=<CITY>
	            //https://www.metaweather.com/api/location/44418/

	            URL url = new URL("https://stock-market-data.p.rapidapi.com/market/index/s-and-p-six-hundred?rapidapi-key=3db93545c3mshce54db9c866f450p1ae782jsn9148f1d0524a");

	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.connect();

	            //Check if connect is made
	            int responseCode = conn.getResponseCode();

	            // 200 OK
	            if (responseCode != 200) {
	                throw new RuntimeException("HttpResponseCode: " + responseCode);
	            } else {
	                StringBuilder informationString = new StringBuilder();
	                Scanner scanner = new Scanner(url.openStream());
	                String result = null;
	                while (scanner.hasNext()) {
	                	//informationString.append(scanner.nextLine());
	                	result = informationString.append(scanner.nextLine()).toString();
	                }
	                //Close the scanner
	                scanner.close();

	                System.out.println(result);

					/*
					 * //JSON simple library Setup with Maven is used to convert strings to JSON
					 * JSONParser parse = new JSONParser(); JSONArray dataObject = (JSONArray)
					 * parse.parse(String.valueOf(informationString));
					 * 
					 * //Get the first JSON object in the JSON array
					 * System.out.println(dataObject.get(0));
					 * 
					 * JSONObject countryData = (JSONObject) dataObject.get(0);
					 * 
					 * System.out.println(countryData.getInt(countryData));
					 */

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
