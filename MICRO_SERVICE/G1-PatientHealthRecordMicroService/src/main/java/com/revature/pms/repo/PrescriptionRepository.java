package com.revature.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pms.model.PrescriptionModal;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionModal, Integer>{

}
