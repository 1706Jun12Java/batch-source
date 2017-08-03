package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.domain.BatType;

@Repository
public interface BatTypeDao extends JpaRepository<BatType,Integer>{

}
