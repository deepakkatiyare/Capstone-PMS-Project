package com.revature.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pms.model.TestsModal;

public interface TestsRepository extends JpaRepository<TestsModal, Integer> {

}
