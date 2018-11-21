package com.cpt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpt.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
