package com.kukimbe.domain;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chuck on 8/22/16.
 */
public class BaseKinveyEntity extends GenericJson {
    private final static Logger LOG = LoggerFactory.getLogger(BaseKinveyEntity.class);

    @Key("_id")
    private String id;


    @Key("_kmd")
    private KinveyMetaData meta; // Kinvey metadata, OPTIONAL

    @Key("_acl")
    private KinveyMetaData.AccessControlList acl; //Kinvey access control, OPTIONAL

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public KinveyMetaData getMeta() {
        return meta;
    }

    public void setMeta(KinveyMetaData meta) {
        this.meta = meta;
    }

    public KinveyMetaData.AccessControlList getAcl() {
        return acl;
    }

    public void setAcl(KinveyMetaData.AccessControlList acl) {
        this.acl = acl;
    }

}
