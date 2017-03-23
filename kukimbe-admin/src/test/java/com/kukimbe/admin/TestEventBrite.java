package com.kukimbe.admin;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chuck on 8/16/16.
 */
public class TestEventBrite {
    private final static Logger LOG = LoggerFactory.getLogger(TestEventBrite.class);
    public static void main(String[] args){
        HttpClient httpclient =  new DefaultHttpClient();
        HttpGet request = new HttpGet("https://www.eventbriteapi.com/v3/users/me/?token=R4SSHRC5SJRJGLH32PVS");
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
                System.out.print(text.toString());
            }
        }catch(IOException ioe){
            System.out.println("Problem");
        } finally {

        }



    }
}
