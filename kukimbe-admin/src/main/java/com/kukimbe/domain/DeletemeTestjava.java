package com.kukimbe.domain;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chuck on 8/15/16.
 */
public class DeletemeTestjava extends GenericJson {
    private final static Logger LOG = LoggerFactory.getLogger(DeletemeTestjava.class);

    @Key("_id")
    private String id;

    @Key
    private String column1;
    @Key
    private String column2;

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

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
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

    public DeletemeTestjava(){

    }
}
