package com.kukimbe.controllers;

import com.kukimbe.domain.ActiveRace;
import com.kukimbe.domain.RaceType;
import com.kukimbe.services.KinveyService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by chuck on 8/17/16.
 */
@RestController
@RequestMapping("/api")
public class APIController {
    private final static Logger LOG = LoggerFactory.getLogger(APIController.class);

    @Autowired
    KinveyService kinveyService;

    @RequestMapping(value="/list", method={RequestMethod.GET})
    public ArrayList<String> getList(){
        ArrayList<String> values = new ArrayList();
        values.add("String 1");
        values.add("String 2");

        return values;
    }

    @RequestMapping(value="/raceList", method={RequestMethod.GET})
    public ArrayList<ActiveRace> getRaceList(){
        ArrayList<ActiveRace> values = new ArrayList();
        ActiveRace race1 = new ActiveRace();
        race1.setName("race 1");
        ActiveRace race2 = new ActiveRace();
        race1.setName("race 2");
        values.add(race1);
        values.add(race2);
        return values;
    }

    @RequestMapping(value="/loadActive", method=RequestMethod.POST)
    public ResponseEntity<String> loadActive(@RequestParam String startDate, @RequestParam String endDate,
                                             @RequestParam String resultsPerPage, @RequestParam String sortBy){
        HttpClient httpclient =  new DefaultHttpClient();
        StringBuilder url = new StringBuilder("http://api.amp.active.com/v2/search/?state=MA&topic=running&current_page=1&exclude_children=true&api_key=jyxbkfzwg8aa482k8thq4cdb&asset.activityStartDate=");
        url.append(startDate);
        url.append("..");
        url.append(endDate);
        url.append("&per_page=");
        url.append(resultsPerPage);
        url.append("&sort=");
        url.append(sortBy);
        LOG.debug("$$$$$$$URL IS: {}", url.toString());
        //HttpGet request = new HttpGet("http://api.amp.active.com/v2/search/?state=MA&topic=running&current_page=1&per_page=10&sort=distance&asset.activityStartDate=2013-09-12..2014-08-31&exclude_children=true&api_key=jyxbkfzwg8aa482k8thq4cdb");
        HttpGet request = new HttpGet(url.toString());
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
            }
        }catch(IOException ioe){
            LOG.error("Problem with Active API");
        } finally {

        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(text.toString(), responseHeaders, HttpStatus.CREATED);

    }

    @RequestMapping(value="/saveRace", method=RequestMethod.POST,headers="Accept=*/*",  produces="application/json")
    @ResponseBody
    public ActiveRace saveRace(@RequestBody ActiveRace race){
        LOG.debug("Race: " + race.getName());

        return race;
    }
    @RequestMapping(value="/saveRaces", method=RequestMethod.POST,headers="Accept=*/*",  produces="application/json")
    @ResponseBody
    public ActiveRace[] saveRaces(@RequestBody ActiveRace[] races){


        return races;
    }

    @RequestMapping(value="raceTypes")
    @ResponseBody
    public RaceType[] getRaceTypes() throws Exception{

        return kinveyService.getRaceTypes();

    }
}
