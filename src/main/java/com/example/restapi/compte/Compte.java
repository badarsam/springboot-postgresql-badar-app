package com.example.restapi.compte;

import com.example.restapi.agence.Agence;
import com.example.restapi.client.Client;

import javax.persistence.*;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double solde;
    private double decouvert;

    @ManyToOne
    @JoinColumn(name = "CODE")
    private Agence agence;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Compte(int id, double solde, double decouvert,String AgenceId,int ClientId) {
        this.id = id;
        this.solde = solde;
        this.decouvert = decouvert;
        this.client = new Client(ClientId,"","",null);
        this.agence = new Agence(AgenceId,"","","");


    }

public Compte(){

}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
