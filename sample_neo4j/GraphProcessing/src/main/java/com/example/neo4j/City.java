package com.example.neo4j;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by harsh on 11/22/16.
 */
@NodeEntity
public class City {

    @GraphId Long id;

    private String name;

    private Boolean isAirportAvailable;

    private Boolean isRailwayStationAvailable;

    private String busCityCode;

    private String flightCityCode;

    private String railCityCode;

    private String cabCityCode;

    @Relationship(type = "CONNECT",direction = Relationship.UNDIRECTED)
    public Set<Connects> connectSet = new HashSet<>();

    public void isConnectedTo(Connects connects){
        connectSet.add(connects);
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusCityCode() {
        return busCityCode;
    }

    public void setBusCityCode(String busCityCode) {
        this.busCityCode = busCityCode;
    }

    public String getFlightCityCode() {
        return flightCityCode;
    }

    public void setFlightCityCode(String flightCityCode) {
        this.flightCityCode = flightCityCode;
    }

    public String getRailCityCode() {
        return railCityCode;
    }

    public void setRailCityCode(String railCityCode) {
        this.railCityCode = railCityCode;
    }

    public String getCabCityCode() {
        return cabCityCode;
    }

    public void setCabCityCode(String cabCityCode) {
        this.cabCityCode = cabCityCode;
    }

    public void addTransport(Connects connects){
        connectSet.add(connects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAirportAvailable() {
        return isAirportAvailable;
    }

    public void setAirportAvailable(Boolean airportAvailable) {
        isAirportAvailable = airportAvailable;
    }

    public Boolean getRailwayStationAvailable() {
        return isRailwayStationAvailable;
    }

    public void setRailwayStationAvailable(Boolean railwayStationAvailable) {
        isRailwayStationAvailable = railwayStationAvailable;
    }
}
