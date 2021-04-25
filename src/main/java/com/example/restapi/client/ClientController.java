package com.example.restapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClientController {
    @Autowired
    ClientService clientService;
    //list all clients
    @RequestMapping("/clients")
    public List<Client> getAllClients(){

        return clientService.getAll();
    }
    //get one single client
    @RequestMapping("/clients/{idclient}")
    public Client getClientById(@PathVariable int idclient){
        return clientService.getClientById(idclient);

    }
    // add a client
    @RequestMapping(method = RequestMethod.POST,value = "/clients")
    public void addClient(@RequestBody Client client){

        clientService.add(client);
    }
    // updating a client
    @RequestMapping(method = RequestMethod.PUT, value="/clients/{idclient}")
    public ResponseEntity<?> updateClient(@RequestBody Client client, @PathVariable int idclient){
        try {
          //  Client existClient = clientService.getClientById(idclient);
            client.setClientid(idclient);
            clientService.update(client,idclient);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //deleting a client
    @RequestMapping(method = RequestMethod.DELETE,value = "/clients/{idclient}")
    public List<Client> delete(@PathVariable int idclient){

        clientService.delete(idclient);
        return clientService.getAll();

    }
}
