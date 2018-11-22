package com.cpt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpt.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

	

}
