package com.example.restapi.compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompteService {
    @Autowired
    CompteRepo repo;

    // list all comptes
    public List<Compte> getAll(){
        List<Compte> comptes = new ArrayList<>();
        repo.findAll().forEach(comptes::add);
        return comptes;
    }

    //List all comptes by a specific agence
    public List<Compte> getCompteByAgence(String AgenceId){
        List<Compte> comptes = new ArrayList<>();
        repo.findByAgenceCode(AgenceId).forEach(comptes::add);
        return comptes;
    }

    //List all comptes by a specific client
    public List<Compte> getCompteByClient(int ClientId){
        List<Compte> comptes = new ArrayList<>();
        repo.findByClientClientid(ClientId).forEach(comptes::add);
        return comptes;
    }


    // get one single compte
    public Compte getCompteById(int id){

        return repo.findById(id).get();
    }

    //add a compte
    public void add(Compte compte){
        repo.save(compte);
    }
    //update a compte
    public void update(Compte compte){
        repo.save(compte);

    }
    //delete a compte
    public void delete(int id){
        repo.deleteById(id);
    }


}
