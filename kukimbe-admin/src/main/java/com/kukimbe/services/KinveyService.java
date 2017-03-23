package com.kukimbe.services;

import com.kinvey.java.AppData;
import com.kinvey.java.User;
import com.kinvey.nativejava.Client;
import com.kukimbe.domain.ActiveRace;
import com.kukimbe.domain.DeletemeTestjava;
import com.kukimbe.domain.RaceCard;
import com.kukimbe.domain.RaceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chuck on 8/21/16.
 */
@Service
public class KinveyService {
    private final static Logger LOG = LoggerFactory.getLogger(KinveyService.class);
    final Client mKinveyClient = new Client.Builder("kid_ZyVpaHoq9e", "fb0a1a59c7b74966b8593827ad9bf399").build();//TODO Rajat to externalize
    public RaceCard saveRace(RaceCard aRace) throws IOException{
        RaceCard savedRace = null;
            boolean loggedIn = login();
            if(loggedIn){
                try{
                    AppData<RaceCard> races = mKinveyClient.appData("temp-race-cards", RaceCard.class);
                    savedRace = races.saveBlocking(aRace).execute();
                    LOG.debug("Race saved with id: {}", savedRace.getId());
                } catch (IOException e) {
                    LOG.error("Couldn't login -> " + e, e);
                    throw e;//TODO work out exception handling
                }
            }
        return savedRace;
    }

    public RaceType[] getRaceTypes() throws IOException{
        boolean loggedIn = login();
        RaceType[] types = null;
        if(loggedIn) {
            AppData<RaceType> raceTypes = mKinveyClient.appData("race-type-ids", RaceType.class);
            types = raceTypes.getBlocking().execute();
        }
        return types;
    }

    public void writeToTable(){
        final Client mKinveyClient = new Client.Builder("kid_ZyVpaHoq9e", "fb0a1a59c7b74966b8593827ad9bf399").build();//TODO Rajat to externalize
        try{
            Boolean pingResult = mKinveyClient.ping();
            System.out.println("Client ping result -> " + pingResult);
            try{
                User result = mKinveyClient.user().loginBlocking("cjbuhecker@yahoo.com", "inde14inde14").execute();//TODO (Rajat to externalize) After auth piece is created, use that object
            } catch (IOException e) {
                System.out.println("Couldn't login -> " + e);
            }
            DeletemeTestjava d = new DeletemeTestjava();
            d.setColumn1("First Column");
            d.setColumn2("Second Column");

            com.kinvey.nativejava.AppData<DeletemeTestjava> deletes = mKinveyClient.appData("deleteme-testjava", DeletemeTestjava.class);
            try {
                DeletemeTestjava result = deletes.saveBlocking(d).execute();

            }catch(IOException e){
                System.out.println("Error saving");
                e.printStackTrace();
            }

        }catch(Exception e){
            System.out.println("something went wrong!");
            e.printStackTrace();
        }

    }

    private boolean login() throws IOException{
        boolean success = false;
        User result = mKinveyClient.user().loginBlocking("cjbuhecker@yahoo.com", "inde14inde14").execute();//TODO After auth piece is created, use that object
        return result.isUserLoggedIn();
    }
}
