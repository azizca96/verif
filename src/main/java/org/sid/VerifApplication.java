package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.dao.ProjetRepository;
import org.sid.dao.UtilisateurRepository;
import org.sid.entities.Contact;
import org.sid.entities.Projet;
import org.sid.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerifApplication implements CommandLineRunner {
//sera   charger automatiquement
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ProjetRepository projetRepository;
	public static void main(String[] args) {
		SpringApplication.run(VerifApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
contactRepository.save(new Contact("mohamedaziz","larafa",df.parse("21/04/1996"),"arafaaziz6@gmail.com","54377784","aziz.jpg"));
utilisateurRepository.save(new Utilisateur("mohamedaziz","larafa",df.parse("21/04/1996"),"arafaaziz6@gmail.com","54377784"));
projetRepository.save(new Projet(dd.parse("21/04/1995"),df.parse("21/04/1996"),"aziz"));
		

		contactRepository.findAll().forEach(c->{
			System.out.print(c.getNom());
		});
		utilisateurRepository.findAll().forEach(c->{
			System.out.print(c.getNom());
		});
		projetRepository.findAll().forEach(c->{
			System.out.print(c.getTitre());
		});
	}
}
