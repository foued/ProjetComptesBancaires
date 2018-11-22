package com.cpt.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpt.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	
	@Query("select o from Operation o where o.compte.codeCompte=:x")
	public Page <Operation> ListOperation(@Param("x")String codecpte,Pageable pageable);

}
