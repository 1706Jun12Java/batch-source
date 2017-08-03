package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.domain.BatColony;

@Repository
public interface BatColonyDao extends JpaRepository<BatColony,Integer>{

}
