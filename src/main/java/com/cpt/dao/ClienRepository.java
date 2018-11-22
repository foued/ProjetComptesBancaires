package com.cpt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpt.entities.Client;

public interface ClienRepository extends JpaRepository<Client, Long> {
	@Query("select c from Client c where c.nom like:x")
	public List<Client> clientparMc(@Param("x")String mc);

}
