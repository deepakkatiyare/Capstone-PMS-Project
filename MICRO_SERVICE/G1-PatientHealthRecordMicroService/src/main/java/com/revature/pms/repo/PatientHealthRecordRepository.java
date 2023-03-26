package com.revature.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.pms.model.PatientHealthRecordModal;

@Repository
public interface PatientHealthRecordRepository extends JpaRepository<PatientHealthRecordModal, Integer>{

}
