package com.example.neo4j.cityResponse;


/**
 * Created by harsh on 11/24/16.
 */
public class BusRoutCityPointDetail {

    private String id;
    private String text;

    public BusRoutCityPointDetail() {
    }

    public BusRoutCityPointDetail(String cityName, String cityCode)
    {
        this.text = cityName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

}
