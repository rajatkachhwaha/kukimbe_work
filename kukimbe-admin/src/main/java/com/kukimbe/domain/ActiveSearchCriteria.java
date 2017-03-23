package com.kukimbe.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chuck on 8/18/16.
 */
public class ActiveSearchCriteria {
    private final static Logger LOG = LoggerFactory.getLogger(ActiveSearchCriteria.class);
    private String startDate;
    private String endDate;
    private String resultsPerPage;
    private String sortBy;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(String resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
