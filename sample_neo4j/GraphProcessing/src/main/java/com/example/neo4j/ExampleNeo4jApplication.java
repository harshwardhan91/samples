package com.example.neo4j;

@SpringBootApplication
@EnableScheduling
public class ExampleNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleNeo4jApplication.class, args);
	}
	/*@Bean
	CommandLineRunner demo(CityRepository repository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

				*//*BusCitiesCollectionTask busCitiesCollectionTask = new BusCitiesCollectionTask();
				busCitiesCollectionTask.getCities();*//*
				City jon = new City();
				City emil = new City();
				City rod = new City();
				Connects connects = new Connects();
				connects.setStartCity(jon);
				connects.setEndCity(emil);
                emil.setName("EMIL");
                jon.setName("JON");
				emil.isConnectedTo(connects);
				jon.isConnectedTo(connects);

				// Persist entities and relationships to graph database
				repository.save(emil);


                for (Connects friend : emil.connectSet) {
                    System.out.println("City: " + friend.getStartCity() + " ======== " + friend.getEndCity());
                }

                System.out.println(repository.findByName("JON").getName());


            }
		};
	}*/
}
