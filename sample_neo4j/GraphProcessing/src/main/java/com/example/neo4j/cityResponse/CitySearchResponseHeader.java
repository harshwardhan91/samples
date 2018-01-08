package com.example.neo4j.cityResponse;


import java.io.Serializable;

/**
 * Created by harsh on 11/24/16.
 */
public class CitySearchResponseHeader implements Serializable
{

    private int status;
    private int QTime;
    private CitySearchParams params;

    public CitySearchResponseHeader() {
    }

    /**
     * @return The status
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(int status)
    {
        this.status = status;
    }

    /**
     * @return The QTime
     */
    public int getQTime()
    {
        return QTime;
    }

    /**
     * @param QueryTime The QTime
     */
    public void setQTime(int QueryTime)
    {
        this.QTime = QueryTime;
    }

    /**
     * @return The params
     */
    public CitySearchParams getParams()
    {
        return params;
    }

    /**
     * @param params The params
     */
    public void setParams(CitySearchParams params)
    {
        this.params = params;
    }

}
