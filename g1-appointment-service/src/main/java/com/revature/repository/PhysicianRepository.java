package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.Physician;

public interface PhysicianRepository extends JpaRepository<Physician,String> {

}
