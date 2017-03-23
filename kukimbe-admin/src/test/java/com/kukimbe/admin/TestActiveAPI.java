package com.kukimbe.admin;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chuck on 8/16/16.
 */
public class TestActiveAPI extends BaseKukimbeTest{
    private final static Logger LOG = LoggerFactory.getLogger(TestActiveAPI.class);




    @Test
    public void testActive(){
        LOG.debug("API KEY IS {}", apikey);

        //http://api.amp.active.com/v2/search/?state=MA&query=running&current_page=1&per_page=10&sort=distance&exclude_children=true&api_key=jyxbkfzwg8aa482k8thq4cdb
        HttpClient httpclient =  new DefaultHttpClient();
        HttpGet request = new HttpGet("http://api.amp.active.com/v2/search/?state=CA&query=running&current_page=1&per_page=10&sort=distance&start_date=2016-08-15..2016-12-31&exclude_children=true&api_key=" + apikey);
        HttpResponse response = null;
        StringBuilder text = new StringBuilder();
        try {
            response = httpclient.execute(request);
            if(response != null){
                BufferedReader rd = new BufferedReader
                        (new InputStreamReader(response.getEntity().getContent()));
                String line = null;

                while ((line = rd.readLine()) != null) {
                    text.append(line);
                }
                System.out.println("Results from ActiveAPI");
                System.out.print(text.toString());
                System.out.println("      ");
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Problem with Active API");
        } finally {

        }
    }
}
