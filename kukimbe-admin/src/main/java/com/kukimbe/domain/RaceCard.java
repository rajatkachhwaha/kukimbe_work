package com.kukimbe.domain;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by chuck on 8/21/16.
 */
public class RaceCard extends BaseKinveyEntity {
    private final static Logger LOG = LoggerFactory.getLogger(RaceCard.class);


    @Key("title")
    private String title;

    @Key("title_normalized")
    private String titleNormalized;


    @Key("description")
    private String description;

    @Key("city")
    private String city;

    @Key("state")
    private String state;

    @Key("zipcode")
    private String zipcode;

    @Key("race_type")
    private String raceType;

    @Key("race_id")
    private String raceId;


    @Key("geoloc")
    private String geolocation;

    @Key("url")
    private String url;

    @Key("registration_url")
    private String registrationUrl;

    @Key("card_type")
    private String cardType;//TODO create enum for this

    @Key("profile_id")
    private String profileId;//TODO ask mike what this references

    @Key("vip_status")
    private Boolean vipStatus = Boolean.FALSE;

    @Key("date")
    private Date date;

    @Key("update_date")
    private Date updateDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleNormalized() {
        return titleNormalized;
    }

    public void setTitleNormalized(String titleNormalized) {
        this.titleNormalized = titleNormalized;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRegistrationUrl() {
        return registrationUrl;
    }

    public void setRegistrationUrl(String registrationUrl) {
        this.registrationUrl = registrationUrl;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(Boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
