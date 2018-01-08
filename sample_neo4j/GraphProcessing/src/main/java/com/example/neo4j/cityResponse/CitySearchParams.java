package com.example.neo4j.cityResponse;


import java.io.Serializable;

/**
 * Created by harsh on 11/24/16.
 */
public class CitySearchParams implements  Serializable
{

    private String q;
    private String wt;

    public CitySearchParams() {
    }

    public String getQ()
    {
        return q;
    }

    public void setQ(String q)
    {
        this.q = q;
    }

    public String getWt()
    {
        return wt;
    }

    public void setWt(String wt)
    {
        this.wt = wt;
    }


}
