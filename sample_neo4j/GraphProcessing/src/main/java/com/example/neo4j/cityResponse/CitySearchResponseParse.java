package com.example.neo4j.cityResponse;

import java.io.Serializable;

/**
 * Created by harsh on 11/24/16.
 */
public class CitySearchResponseParse implements Serializable
{

    private CitySearchResponseHeader responseHeader;
    private CitySearchResponse response;

    public CitySearchResponseParse() {
    }

    /**
     * @return The responseHeader
     */
    public CitySearchResponseHeader getResponseHeader()
    {
        return responseHeader;
    }

    /**
     * @param responseHeader The responseHeader
     */
    public void setResponseHeader(CitySearchResponseHeader responseHeader)
    {
        this.responseHeader = responseHeader;
    }

    /**
     * @return The response
     */
    public CitySearchResponse getResponse()
    {
        return response;
    }

    /**
     * @param response The response
     */
    public void setResponse(CitySearchResponse response)
    {
        this.response = response;
    }


}
