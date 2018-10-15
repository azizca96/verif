package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ProjetRepository;
import org.sid.entities.Projet;
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
public class ProjetRestService {
   
	@Autowired
	private ProjetRepository projetRepository;
    @RequestMapping(value="/project",method=RequestMethod.GET)
	public List<Projet> getProjets(){
	return projetRepository.findAll();
	//afficher format Json
}

    @RequestMapping(value="/projett/{id}",method=RequestMethod.GET)
	public Optional<Projet> getProjet1(@PathVariable Long id){
	return projetRepository.findById(id);
	//recherche   by Id
	 
}
    @RequestMapping(value="/rechercherProjet",method=RequestMethod.GET)
	public Page<Projet> chercher(
			@RequestParam(name="mc" ,defaultValue="") String mc,
			@RequestParam(name="page" ,defaultValue="0")int page,
			@RequestParam(name="size" ,defaultValue="5")int size){

	return projetRepository.chercher("%"+mc+"%", new PageRequest(page, size));
}
    //recherche
    
    @RequestMapping(value="/postProjet",method=RequestMethod.POST)
   	public Projet save (@RequestBody Projet c){
   	return projetRepository.save(c);}
    //inserer des informations
   	
   	
   	
    @RequestMapping(value="/deleteProjet/{id}",method=RequestMethod.DELETE)
   	public boolean supprimer (@PathVariable Long id){
   	
    	projetRepository.deleteById(id);
    	
    	return true;}
    //supprimer les informations
    
    @RequestMapping(value="/updateProjet/{id}",method=RequestMethod.PUT)
   	public Projet save (@PathVariable Long id,@RequestBody Projet c){
   	
    	c.setId(id);
    	return projetRepository.save(c);}
   	// mise à jours
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	 
   }
    
    
    


