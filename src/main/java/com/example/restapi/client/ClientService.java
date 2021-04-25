package com.example.restapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo repo;

    //list all topics
    public List<Client> getAll(){
        List<Client> clients = new ArrayList<>();
        repo.findAll().forEach(clients::add);
        return clients;

    }
    //get single agence by id
    public Client getClientById(int idclient){

        return repo.findById(idclient).get();
    }
    //add an agence
    public void add(Client client){
        repo.save(client);
    }
    //update an agence
    public void update(Client client, int idclient){
        repo.save(client);

    }
    //delete an agence
    public void delete(int idclient){
        repo.deleteById(idclient);
    }


}
