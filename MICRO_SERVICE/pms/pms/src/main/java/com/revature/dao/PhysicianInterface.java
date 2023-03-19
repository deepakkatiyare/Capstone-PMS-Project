package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Physician;

public interface PhysicianInterface extends JpaRepository<Physician, String>{

}
