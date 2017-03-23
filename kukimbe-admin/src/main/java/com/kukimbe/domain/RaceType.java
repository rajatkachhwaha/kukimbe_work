package com.kukimbe.domain;

import com.google.api.client.util.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chuck on 8/22/16.
 */
public class RaceType extends BaseKinveyEntity {
    private final static Logger LOG = LoggerFactory.getLogger(RaceType.class);

    @Key("race_name")
    private String raceName;

    @Key("race_column_order")
    private Integer columnOrder;

    @Key("race_image")
    private String raceImage;

}
