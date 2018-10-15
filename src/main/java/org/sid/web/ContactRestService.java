package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
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
public class ContactRestService {
   
	@Autowired
	private ContactRepository contactRepository;
    @RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContacts(){
	return contactRepository.findAll();
	//afficher format Json
}

    @RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContacts1(@PathVariable Long id){
	return contactRepository.findById(id);
	//recherche   by Id
	 
}
    @RequestMapping(value="/rechercher",method=RequestMethod.GET)
	public Page<Contact> chercher(
			@RequestParam(name="mc" ,defaultValue="") String mc,
			@RequestParam(name="page" ,defaultValue="0")int page,
			@RequestParam(name="size" ,defaultValue="5")int size){

	return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
}
    //recherche
    
    @RequestMapping(value="/post",method=RequestMethod.POST)
   	public Contact save (@RequestBody Contact c){
   	return contactRepository.save(c);}
    //inserer des informations
   	
   	
   	
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
   	public boolean supprimer (@PathVariable Long id){
   	
    	contactRepository.deleteById(id);
    	
    	return true;}
    //supprimer les informations
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
   	public Contact save (@PathVariable Long id,@RequestBody Contact c){
   	
    	c.setId(id);
    	return contactRepository.save(c);}
   	// mise à jours
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	 
   }
    
    
    

