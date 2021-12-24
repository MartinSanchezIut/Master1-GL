package fr.sanchez.AgenceService;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.sanchez.AgenceService.DistantModels.ClientD;
import fr.sanchez.AgenceService.DistantModels.Offre;
import fr.sanchez.AgenceService.DistantModels.ReservationD;
import fr.sanchez.AgenceService.Model.Agence;
import fr.sanchez.AgenceService.Model.Hotel;
import fr.sanchez.AgenceService.Repositories.AgenceRepository;
import fr.sanchez.AgenceService.Repositories.HotelRepository;


@Component
public class Main {
	@Autowired
	private AgenceRepository a;
	@Autowired
	private HotelRepository h;

	@Autowired
	RestTemplate proxy;	
	
	String img_path = "src/main/resources/ImgDdl/" ;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	makeData() ;
    	
    	runCLI() ;
    }
    
    public void runCLI() {
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Bonjour, selectionnez une agence parmis les choix suivant :");
		List<Agence> agences = a.findAll();
		for (int i = 0; i < agences.size(); i++) {
			System.out.println("	" + i + " - " + agences.get(i).getNom());
		}
		int agenc = sc.nextInt();
		Agence agence = agences.get(agenc);
		
		System.out.println("\nBienvenu chez l'agence : " + agence.getNom());
		sc.reset();
		
		System.out.println("Reservez un hotel : ");
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
		
		// /agence/1/lookup/ville=Montpellier,etoiles=3,from=0-0-0,to=1000-0-0,priceMin=30,priceMax=50,beds=3
		String url = "http://localhost:8081/agence/" + agence.getId() + "/lookup/ville="+ville + ",etoiles="+etoiles
					 + ",from="+date + ",to="+date1 + ",priceMin="+prixMin + ",priceMax="+prixMax + ",beds="+lits;
		
		Offre[] response = proxy.getForObject(url, Offre[].class);
		//List<Offre> response = agence.rechercher(ville, date, date1, prixMin, prixMax, etoiles, lits);
		for(int i = 0; i < response.length; i++) {
			System.out.println(" - " + i + " : " + response[i].toString());
		}
		if (response.length == 0) {
			System.out.println("Rien trouve");
			System.exit(1);
		}
		
		System.out.println("Quelle offre vous interesse ?");
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

		url = "http://localhost:8080/client";
		ClientD creationClient = proxy.postForObject(url, cli, ClientD.class);

		
		
		ReservationD resa = new ReservationD(response[idCham].getChambre().getId().intValue(),
				creationClient.getId().intValue(), date, date1);
				
		url = "http://localhost:8080/reservation";
		ReservationD creationResa = proxy.postForObject(url, resa, ReservationD.class);

		System.out.println("C'est réservé. (" + creationResa.getId() + ")");	
		System.out.println("Telechargement de l'image ...");
        	
		try {
			BufferedImage bi = ImageIO.read(response[idCham].getChambre().getImg());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        ImageIO.write(bi, "jpg", bos);
	        
	        byte [] data = bos.toByteArray();
	        ByteArrayInputStream bis = new ByteArrayInputStream(data);
	        BufferedImage bImage2 = ImageIO.read(bis);
	        File file = new File(img_path+ response[idCham].getChambre().getNom() + "-output.jpg");
	        if (file.exists()) { file.delete();}
	        file.createNewFile() ;
	        ImageIO.write(bImage2, "jpg", file );
	        System.out.println("Image crée : " + file.getAbsolutePath());	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
    
    public void makeData() {
    	a.save(new Agence(null, "Agence 1", "123")) ;
    	a.save(new Agence(null, "Agence 2", "123")) ;
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/1", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/1", 2));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/2", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/2", 2));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/3", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/3", 2));
    	
       	h.save(new Hotel(null, "http://localhost:8080/hotel/4", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/4", 2));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/5", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/5", 2));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/6", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/6", 2));

    	h.save(new Hotel(null, "http://localhost:8080/hotel/7", 1));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/7", 2));
    }
}