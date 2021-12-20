package fr.sanchez.AgenceService.DistantModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Cli implements CommandLineRunner{

	@Autowired
	RestTemplate proxy;	
	
	@Override
	public void run(String... args) throws Exception {

		String uri = "http://localhost:8080/hotel";
		Hotel[] test = proxy.getForObject(uri, Hotel[].class);
		
		System.out.println("Hotels:");
		for(Hotel h : test) {
			System.out.println(h.getName() + " " + h.getEtoiles() + " " + h.getVille() + " " + h.getId());
		}		
	}

	
}
