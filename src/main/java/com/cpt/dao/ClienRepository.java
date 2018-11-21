package com.cpt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpt.entities.Client;

public interface ClienRepository extends JpaRepository<Client, Long> {

}
