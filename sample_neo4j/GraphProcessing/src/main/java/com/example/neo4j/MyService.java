package com.example.neo4j;

import com.example.neo4j.cityResponse.BusRoutCityPointDetail;
import com.example.neo4j.cityResponse.CitySearchResponseParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Created by harsh on 11/25/16.
 */
//@Service
//@Configuration
@Component
public class MyService {

    @Autowired
    private CityRepository repository;



    @Transactional
    @Scheduled(fixedDelay = 10*60*1000)
    public void doWork() {

     /*   City jon = new City();
        City emil = new City();
        City rod = new City();

        Connects connects = new Connects();
        connects.setStartCity(jon);
        connects.setEndCity(emil);
        emil.isConnectedTo(connects);
        jon.isConnectedTo(connects);

        // Persist entities and relationships to graph database
        repository.save(emil);

        for (Connects friend : emil.connectSet) {
            System.out.println("Friend: " + friend);
        }
*/
        /*// Control loading depth
        City thatSamejon = repository.findOne(id, 2);
        for (City friend : jon.getFriends()) {
            System.out.println("Jon's friends to depth 2: " + friend);
        }*/


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        String solrUrlBusCities = "https://bus.makemytrip.com/bus/common/cities?q=city_name_suggest_edge:A";
        ResponseEntity<CitySearchResponseParse> forEntity = restTemplate.getForEntity(solrUrlBusCities, CitySearchResponseParse.class);
        System.out.println(forEntity);
        for (int i = 0; i < forEntity.getBody().getResponse().getDocs().size(); i++) {
            BusRoutCityPointDetail busRoutCityPointDetail = forEntity.getBody().getResponse().getDocs().get(i);
            City city = new City();
            city.setName(busRoutCityPointDetail.getText());
            city.setBusCityCode(busRoutCityPointDetail.getId());
            repository.save(city);
        }
    }
}
