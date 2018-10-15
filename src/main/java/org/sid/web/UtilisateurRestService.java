package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.UtilisateurRepository;
import org.sid.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
//crossorigin dans chaque rep http il inclu une entete access-control-allow-origin dans le browser
public class UtilisateurRestService {
   
	@Autowired
	private UtilisateurRepository utilisateurRepository;
    @RequestMapping(value="/user",method=RequestMethod.GET)
	public List<Utilisateur> getUtilisateurs(){
	return utilisateurRepository.findAll();
	//afficher format Json
}

    @RequestMapping(value="/userr/{id}",method=RequestMethod.GET)
	public Optional<Utilisateur> getUtilisateur1(@PathVariable Long id){
	return utilisateurRepository.findById(id);
	//recherche   by Id
	 
}
    @RequestMapping(value="/rechercherUser",method=RequestMethod.GET)
	public Page<Utilisateur> chercher(
			@RequestParam(name="mc" ,defaultValue="") String mc,
			@RequestParam(name="page" ,defaultValue="0")int page,
			@RequestParam(name="size" ,defaultValue="5")int size){

	return utilisateurRepository.chercher("%"+mc+"%", new PageRequest(page, size));
}
    //recherche
    
    @RequestMapping(value="/postUser",method=RequestMethod.POST)
   	public Utilisateur save (@RequestBody Utilisateur c){
   	return utilisateurRepository.save(c);}
    //inserer des informations
   	
   	
   	
    @RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE)
   	public boolean supprimer (@PathVariable Long id){
   	
    	utilisateurRepository.deleteById(id);
    	
    	return true;}
    //supprimer les informations
    
    @RequestMapping(value="/updateUser/{id}",method=RequestMethod.PUT)
   	public Utilisateur save (@PathVariable Long id,@RequestBody Utilisateur c){
   	
    	c.setId(id);
    	return utilisateurRepository.save(c);}
   	// mise à jours
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	 
   }
    
    
    


