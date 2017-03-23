import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class DataRead {
    public static void main (String[] args){
    	HttpClient httpClient = HttpClientBuilder.create().build();
    	String URL= "https://runsignup.com/Rest/races/?"                   //url using parameters, api keys and api secret
    			+ "format=json&"
    			+ "events=F&"
    			+ "race_headings=F&"
    			+ "race_links=F&"
    			+ "include_waiver=F&"
    			+ "page=1&"
    			+ "results_per_page=1000&"
    			+ "sort=name+ASC&"
    			+ "start_date=today&"
    			+ "end_date=2016-11-30&"
    			+ "only_partner_races=F&"
    			+ "search_start_date_only=F&"
    			+ "only_races_with_results=F&"
    			+ "state=CA&"
    			+ "distance_units=K&"
    			+ "api_key=N3vQNyRKB11BOGyc5KhVjb1F3z8KOXnr&"
    			+ "api_secret=QI7t6O4yGVZksomoZt98v0DpqB04pdl6";
    	
    	HttpGet request = new HttpGet(URL);
    	
    	HttpResponse response = null;
    	StringBuilder text = new StringBuilder();
    	try {
    	    response = httpClient.execute(request);
    	    if(response != null){
    	        BufferedReader rd = new BufferedReader
    	                (new InputStreamReader(response.getEntity().getContent()));
    	        String line = null;

    	        while ((line = rd.readLine()) != null) {
    	            text.append(line);
    	        }
    	        System.out.print(text.toString());
    	    }
    	}catch(IOException ioe){
    	    System.out.println("Problem");
    	} finally {
    	}
    	
    	
    System.exit(0);	
    	
    }
}
