package com.example.restapi.client;


import com.example.restapi.compte.Compte;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientid;
    @Column(nullable=false)
    private String prenom;
    @Column(nullable=false)
    private String nom;
    @Column(nullable=false)
    private Date date_naissance;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Compte> comptes;



    public Client(int id, String prenom, String nom, Date date_naissance) {
        this.clientid = id;
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
    }

    public Client(){

    }


    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }
}
