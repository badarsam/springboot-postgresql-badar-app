package com.example.restapi.agence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenceService {
    @Autowired
    private AgenceRepo repo;

    public AgenceService(){
    }
    
    //list all topics
    public List<Agence> getAll(){
        List<Agence> agences = new ArrayList<>();
        repo.findAll().forEach(agences::add);
        return agences;
    }
    
    //get single agence by id
    public Agence getAgenceById(String code){
        return repo.findById(code).get();
    }
    
    //add an agence
    public void add(Agence agence){
        repo.save(agence);
    }
    
    //update an agence
    public void update(Agence agence , String code){
        repo.save(agence);
    }
    
    //delete an agence
    public void delete(String code){
        repo.deleteById(code);
    }

    //Verify an agence exist ?
    public boolean agenceByIdExist(String code) {
    	return repo.findById(code).isPresent();
    }	
    

}
