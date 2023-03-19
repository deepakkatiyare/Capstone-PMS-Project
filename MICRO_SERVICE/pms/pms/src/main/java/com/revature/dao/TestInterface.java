package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Test;

public interface TestInterface extends JpaRepository<Test, Integer>{

}
