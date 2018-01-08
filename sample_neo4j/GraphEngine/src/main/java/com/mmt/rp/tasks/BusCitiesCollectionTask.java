package com.mmt.rp.tasks;

import com.mmt.rp.nodes.City;
import com.mmt.rp.repositories.CityRepository;
import com.mmt.rp.responseEntities.BusRoutCityPointDetail;
import com.mmt.rp.responseEntities.CitySearchResponseParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Created by harsh on 11/24/16.
 */
@Component
public class BusCitiesCollectionTask {

    @Autowired
    private CityRepository cityRepository;


    @Transactional
    @Scheduled(fixedDelay = 10*60*1000)
    public void getCities(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json; charset=utf-8");
        String solrUrlBusCities = "https://bus.makemytrip.com/bus/common/cities?q=city_name_suggest_edge:A";
        ResponseEntity<CitySearchResponseParse> forEntity = restTemplate.getForEntity(solrUrlBusCities, CitySearchResponseParse.class);
        System.out.println(forEntity);
        for (int i = 0; i < forEntity.getBody().getResponse().getDocs().size(); i++) {
            BusRoutCityPointDetail busRoutCityPointDetail = forEntity.getBody().getResponse().getDocs().get(i);
            City city = new City();
            city.setName(busRoutCityPointDetail.getText());
            city.setBusCityCode(busRoutCityPointDetail.getId());
            cityRepository.save(city);
        }
    }


    public static void main(String[] args) {
        BusCitiesCollectionTask busCitiesCollectionTask = new BusCitiesCollectionTask();
        busCitiesCollectionTask.getCities();
    }

}
