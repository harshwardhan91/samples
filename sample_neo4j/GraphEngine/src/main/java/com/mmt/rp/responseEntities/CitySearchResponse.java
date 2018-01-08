package com.mmt.rp.responseEntities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harsh on 11/24/16.
 */
public class CitySearchResponse {


    private int numFound;
    private int start;
    private List<BusRoutCityPointDetail> docs = new ArrayList<BusRoutCityPointDetail>();

    public CitySearchResponse() {
    }

    /**
     * @return The numFound
     */
    public int getNumFound()
    {
        return numFound;
    }

    /**
     * @param numFound The numFound
     */
    public void setNumFound(int numFound)
    {
        this.numFound = numFound;
    }

    /**
     * @return The start
     */
    public int getStart()
    {
        return start;
    }

    /**
     * @param start The start
     */
    public void setStart(int start)
    {
        this.start = start;
    }

    /**
     * @return The docs
     */
    public List<BusRoutCityPointDetail> getDocs()
    {
        return docs;
    }

    /**
     * @param docs The docs
     */
    public void setDocs(List<BusRoutCityPointDetail> docs)
    {
        this.docs = docs;
    }

}
