package com.example.restapi.agence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AgenceController {
    @Autowired
    AgenceService agenceService;

    //list all agents
    @RequestMapping("/agences")
    public List<Agence> getAllAgents(){
        return agenceService.getAll();
    }
    
    //get one single agent
    @RequestMapping("/agences/{id}")
    public Agence getAgenceById(@PathVariable String id){
        return agenceService.getAgenceById(id);

    }
    
    // add an agence
    @RequestMapping(method = RequestMethod.POST,value = "/agences")
    public void addAgence(@RequestBody Agence agence){
        agenceService.add(agence);
    }

    // updating an agence
    @RequestMapping(method = RequestMethod.PUT, value="/agences/{id}")
    public void addTopic(@RequestBody Agence agence,@PathVariable String id){

        agenceService.update(agence,id);
    }

    //deleting an agence
    @RequestMapping(method = RequestMethod.DELETE,value = "/agences/{id}")
    public  void delete(@PathVariable String id){

        agenceService.delete(id);
    }
    
    //Verify an agence exist
    @RequestMapping("/agences/existe/{code}")
    public boolean agenceByIdExiste(@PathVariable String code) {
    	return agenceService.agenceByIdExist(code);
    	
    }

}
