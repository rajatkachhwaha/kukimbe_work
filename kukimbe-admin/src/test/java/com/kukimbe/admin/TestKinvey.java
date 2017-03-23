package com.kukimbe.admin;

import com.kinvey.java.User;
import com.kinvey.nativejava.AppData;
import com.kinvey.nativejava.Client;
import com.kukimbe.admin.config.KukimbeAppConfig;
import com.kukimbe.domain.RaceCard;
import com.kukimbe.domain.RaceType;
import com.kukimbe.services.KinveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by chuck on 8/15/16.
 */
@WebAppConfiguration
@PropertySource({"classpath:kukimbe.properties"})
@ContextConfiguration(classes= KukimbeAppConfig.class, loader = AnnotationConfigWebContextLoader.class)
@ComponentScan(basePackages = "com.kukimbe")
public class TestKinvey  extends BaseKukimbeTest {
    @Autowired
    WebApplicationContext wac;


    @Autowired
    KinveyService kinveyService;

    private final static Logger LOG = LoggerFactory.getLogger(TestKinvey.class);
    @Test(enabled = false)
    public void testKinveyWrite(){
        kinveyService.writeToTable();
    }

    @Test(enabled = true)
    public void getetRaceTypes() throws Exception{
        RaceType[] types = kinveyService.getRaceTypes();
        Assert.assertTrue(types != null);
        Assert.assertTrue(types.length>0);
    }


    @Test(enabled = false)
    public void testCreateRace() throws Exception {
        RaceCard rc = new RaceCard();
        rc.setCity("some city");
        rc.setDescription("first description of some race");
//        String [] geo = {"-71.348229", "42.649481"};
        rc.setGeolocation("[-71.348229,42.649481]");
        rc.setCardType("race_card");
//        //rc.setDate(new Date());
        rc.setProfileId("30");
        rc.setRaceId(UUID.randomUUID().toString());
        rc.setRaceType("10K");
        rc.setRegistrationUrl("http://www.somewhere.com");
        rc.setState("MA");
        rc.setTitle("first kinvey insert race");
        rc.setTitleNormalized("firstkinveyinsertrace");
        rc.setUrl("http://www.somewhereelse.com");
        rc.setZipcode("02184");

            RaceCard savedRace = kinveyService.saveRace(rc);
            LOG.debug(savedRace.getId());

    }
}
