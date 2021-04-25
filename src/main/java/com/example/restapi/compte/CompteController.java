package com.example.restapi.compte;
import com.example.restapi.agence.Agence;
import com.example.restapi.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CompteController {

    @Autowired
    CompteService service;


    //list all comptes
    @RequestMapping("/comptes")
    public List<Compte> getAllComptes(){

        return service.getAll();
    }

    // list all comptes for an specific agence
    @RequestMapping("/agences/{AgenceId}/comptes")
    public List<Compte> getAllCompteByAgence(@PathVariable String AgenceId){
        return service.getCompteByAgence(AgenceId);

    }

    // List all comptes for a specific client
    @RequestMapping("/clients/{ClientId}/comptes")
    public List<Compte> getAllCompteByClient(@PathVariable int ClientId) {
        return service.getCompteByClient(ClientId);

    }


    //get on single compte
    @RequestMapping("/agences/{AgenceId}/{ClientId}/{id}")
    public Compte getCompteById(@PathVariable int id, @PathVariable String ClientId) {
        return service.getCompteById(id);
    }
    //add a compte in a agence and for a client

       @RequestMapping(method = RequestMethod.POST,value = "/agences/{AgenceId}/{ClientId}/comptes")
       public void addCompte(@RequestBody Compte compte, @PathVariable String AgenceId, @PathVariable int ClientId){
            compte.setAgence(new Agence(AgenceId,"","",""));
            compte.setClient(new Client(ClientId,"","",null));
            service.add(compte);

       }
     // update a compte in a agence and for a client
    @RequestMapping(method = RequestMethod.PUT,value = "/agences/{AgenceId}/{ClientId}/comptes/{id}")
    public void updateCompte(@RequestBody Compte compte, @PathVariable String AgenceId, @PathVariable int ClientId,@PathVariable int id){
        compte.setAgence(new Agence(AgenceId,"","",""));
        compte.setClient(new Client(ClientId,"","",null));
        service.update(compte);
    }

    //delete a compte
    @RequestMapping(method = RequestMethod.DELETE,value ="/comptes/{id}" )
    public void deleteCompte(@PathVariable int id){
        service.delete(id);
    }



    }







