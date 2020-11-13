package com.myhu.cheela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myhu.cheela.entity.Predictions;

@Repository
public interface FruadTransactionRepository extends JpaRepository<Predictions,Long>{
	
}
