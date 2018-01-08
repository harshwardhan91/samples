package com.mmt.rp.repositories;

import com.mmt.rp.nodes.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by harsh on 11/24/16.
 */
@Repository
public interface CityRepository extends Neo4jRepository<City> {

    public City findByName(String name);
}
