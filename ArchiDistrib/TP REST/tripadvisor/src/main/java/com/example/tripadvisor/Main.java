package com.example.tripadvisor;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.tripadvisor.Model.Agence;
import com.example.tripadvisor.Model.AgenceD;
import com.example.tripadvisor.Model.Offre;
import com.example.tripadvisor.Repositories.AgenceRepository;

import com.example.tripadvisor.Model.ClientD;
import com.example.tripadvisor.Model.ReservationD;

@Component
public class Main extends AbstractMain implements CommandLineRunner {
	
	/* ATTRIBUTES */
	@Autowired
	private RestTemplate proxy;
	
	@Autowired
	private AgenceRepository repo;
	
	private IntegerInputProcessor inputProcessor;
	
	String img_path = "src/main/resources/ImgDdl/" ;

	
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
				Thread.sleep(2000);
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
		Scanner sc = new Scanner(System.in);
		try {
			switch(userInput) {
				case "1":
					// Afficher toutes les agences
					List<Agence> agences = repo.findAll();	
					
					if (agences.size() == 0) {
						System.out.println("Aucune agence a afficher.");
					}else {
						for (Agence a : agences) {
							String uri = a.getUri();
							AgenceD agence = proxy.getForObject(uri, AgenceD.class);
							
							System.out.println(agence.getId() + " =>  " + agence.getNom() + " : " + agence.getMdp());
						}
					}
					System.out.println();
				break;
						
				case "2":
					// Ajouter une agence
					System.out.println("URI du web service de l'agence : ");
					String uri_agence = ""; 
					do{
						uri_agence =  reader.readLine() ;
					}while (uri_agence.equalsIgnoreCase(""));
					System.out.println("Recherche de l'agence ....");
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
				
				case "4":
					System.out.println("Dans quelle ville ?");
					String ville = "";
					do {
						ville = sc.nextLine();
					}while (ville.equals(""));
					
					System.out.println("Date d'arrivée ? (aaaa/mm/jj)");
					String date = "";
					do {
						date = sc.nextLine();
					}while (date.equals(""));
					
					
					System.out.println("Date de depart ? (aaaa/mm/jj)");
					String date1 = "";
					do {
						date1 = sc.nextLine();
					}while (date1.equals(""));	
					
					
					System.out.println("Prix min ?");
					int prixMin = sc.nextInt();
				
					System.out.println("Prix max ? ");
					int prixMax = sc.nextInt();
					
					System.out.println("Combien d'etoiles l'hotel ?");
					int etoiles = sc.nextInt();
					
					System.out.println("Nombre lits ? ");
					int lits = sc.nextInt();	
					
					System.out.println("\n\nResumons, vous cherchez : ");
					System.out.println("A " + ville + ", du " + date + " au " + date1);
					System.out.println("Entre " + prixMin + " et " + prixMax + "euros, " + etoiles + "Etoiles, et pour " + lits + "lits.");
					
					System.out.println();
					List<Agence> liste_Agences = repo.findAll();
					System.out.println("On recherche dans " + liste_Agences.size() + " agences.");
					
					List<Offre> offres = new ArrayList<>();
					for (Agence a : liste_Agences) {
						String URL = a.getUri() + "/lookup/ville="+ville + ",etoiles="+etoiles
								 				+ ",from="+date + ",to="+date1 + ",priceMin="+prixMin 
								 				+ ",priceMax="+prixMax + ",beds="+lits;
								 
						AgenceD ag = proxy.getForObject(a.getUri(), AgenceD.class);
						Offre[] off = proxy.getForObject(URL, Offre[].class);
						for (Offre o : off) {
							o.setAgence(ag);
							offres.add(o);
						}
					}
					
					List<Offre> finalList = new ArrayList<>();
					// Pour toutes les offres; si pour une meme chambre, je suis une des meilleures offres : Ajouter a la liste finale 
					for (Offre o : offres) {
						boolean valid = true;
						for (Offre o1 : offres) {
							if (o.getChambre().getId().equals( o1.getChambre().getId())) {
								if (o.getPrix() > o1.getPrix()) {
									valid = false;
								}
							}
						}
						
						if (valid) {
							finalList.add(o);
						}
					}
					
					System.out.println(finalList.size() + " / " + offres.size());
					for(int i = 0; i < finalList.size(); i++) {
						System.out.println(" - " + i + " : " + finalList.get(i).toString());
					}
					if (finalList.size() == 0) {
						System.out.println("Rien trouve");
						break;
					}
					
					System.out.println("Voici les meilleures offres : \n Laquelle vous interesse ?");
					int idCham = sc.nextInt();
					
					System.out.println("Entrez vos coordones : nom ?");
					String nom = "";
					do {
						nom = sc.nextLine();
					}while (nom.equals(""));	
					System.out.println("Entrez vos coordones : prenom ?");
					String prenom = "";
					do {
						prenom = sc.nextLine();
					}while (prenom.equals(""));
					System.out.println("Entrez vos coordones : carte ?");
					String carte = "";
					do {
						carte = sc.nextLine();
					}while (carte.equals(""));
					
					ClientD cli = new ClientD(nom, prenom, carte);

					String url_creation_client = "http://localhost:8080/client";
					ClientD creationClient = proxy.postForObject(url_creation_client, cli, ClientD.class);

					
					
					ReservationD resa = new ReservationD(finalList.get(idCham).getChambre().getId().intValue(),
							creationClient.getId().intValue(), date, date1);
							
					String url_creation_reservation = "http://localhost:8080/reservation";
					ReservationD creationResa = proxy.postForObject(url_creation_reservation, resa, ReservationD.class);

					System.out.println("C'est réservé. (" + creationResa.getId() + ")");	
					
					System.out.println("Telechargement de l'image ...");
		        	
					try {
						BufferedImage bi = ImageIO.read(finalList.get(idCham).getChambre().getImg());
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
				        ImageIO.write(bi, "jpg", bos);
				        
				        byte [] data = bos.toByteArray();
				        ByteArrayInputStream bis = new ByteArrayInputStream(data);
				        BufferedImage bImage2 = ImageIO.read(bis);
				        File file = new File(img_path+ finalList.get(idCham).getChambre().getNom() + "-output.jpg");
				        if (file.exists()) { file.delete();}
				        file.createNewFile() ;
				        ImageIO.write(bImage2, "jpg", file );
				        System.out.println("Image crée : " + file.getAbsolutePath());	        
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					break;
				
				case QUIT:
					System.out.println("Bye...");
					System.exit(0);
					break;
				default:
					System.err.println("Sorry, wrong input. Please try again.");
					break;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			System.err.println(e.getMessage());
			System.err.println("Please try again with a different ID.");
		}
	}
}