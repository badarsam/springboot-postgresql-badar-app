package com.example.restapi.compte;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepo extends JpaRepository<Compte,Integer> {

 public List<Compte> findByAgenceCode(String AgenceId);
 public List<Compte> findByClientClientid(int ClientId);

}
