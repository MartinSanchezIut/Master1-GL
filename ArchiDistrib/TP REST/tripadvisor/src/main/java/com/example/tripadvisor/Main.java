package com.example.tripadvisor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.tripadvisor.Model.Agence;
import com.example.tripadvisor.Model.AgenceD;
import com.example.tripadvisor.Repositories.AgenceRepository;

@Component
public class Main extends AbstractMain implements CommandLineRunner {
	
	/* ATTRIBUTES */
	@Autowired
	private RestTemplate proxy;
	
	@Autowired
	private AgenceRepository repo;
	
	private IntegerInputProcessor inputProcessor;
	
	
	/* METHODS */
	@Override
	public void run(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		try {
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			do {
				menu();
				userInput = inputReader.readLine();
				processUserInput(inputReader, userInput, proxy);
				Thread.sleep(3000);
			} while(!userInput.equals(QUIT));

		} catch (IOException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected boolean validServiceUrl() {
		return SERVICE_URL.equals("http://localhost:8081");
	}
	
	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quitter.");
		builder.append("\n1. Afficher toutes nos agences.");
		builder.append("\n2. Ajouter une agence.");
		builder.append("\n3. Supprimer une agence.");
		builder.append("\n4. Comparer les offres de nos agences."); 
		System.out.println(builder);
	}
	
	private void processUserInput(BufferedReader reader,String userInput, RestTemplate proxy) {
		Map<String, String> params = new HashMap<>();
		inputProcessor = new IntegerInputProcessor(reader);
		try {
			switch(userInput) {
				case "1":
					// Afficher toutes les agences
					List<Agence> agences = repo.findAll();								
					for (Agence a : agences) {
						String uri = a.getUri();
						AgenceD agence = proxy.getForObject(uri, AgenceD.class);
						
						System.out.println(agence.getId() + " =>  " + agence.getNom() + " : " + agence.getMdp());
					}
					System.out.println();
				break;
						
				case "2":
					// Ajouter une agence
					System.out.println("URI du web service de l'agence : ");
					String uri_agence = ""; 
					do{
						reader.readLine() ;
					}while (uri_agence.equalsIgnoreCase(""));
					AgenceD agence ;
				    try {
				    	agence = proxy.getForObject(uri_agence, AgenceD.class);
				    	Agence add = new Agence(null, uri_agence);
				    	repo.save(add) ;
				    	System.out.println("L'agence a été ajoutée ! Détail: ");
						System.out.println(agence.getId() + " =>  " + agence.getNom() + " : " + agence.getMdp());
				    }catch (HttpServerErrorException e) {
						System.out.println("Cette agence n'est pas trouvable, impossible de l'ajouter.");
					}
					System.out.println();
				break;
				
				case "3":
					// Supprimer une agence
					System.out.println("Identifiant de l'agence a supprimer : ");
					int id = inputProcessor.process() ; 					
					List<Agence> liste = repo.findAll();
					for (Agence a : liste) {
						String uri = a.getUri();
						AgenceD ag = proxy.getForObject(uri, AgenceD.class);
						if (id == ag.getId()) {
							repo.delete(a);
							System.out.println(ag.getId() + " =>  " + ag.getNom() + " : " + ag.getMdp());
							System.out.println("a ete supprimé.");
						}
					}
					System.out.println();
					break;
				
				case "4":/*
					uri = URI_EMPLOYEES_ID;
					System.out.println("Employee ID:");
					id = inputProcessor.process();
					params.put("id", String.valueOf(id));
					proxy.delete(uri, params);
					System.out.println(String.format("Successfully removed employee with ID %s", id));
					System.out.println();
				*/break;
				
				case QUIT:
					System.out.println("Bye...");
					System.exit(0);
				default:
					System.err.println("Sorry, wrong input. Please try again.");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			System.err.println(e.getMessage());
			System.err.println("Please try again with a different ID.");
		}
	}
}