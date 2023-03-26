package com.revature.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.pms.entity.PhysicianAvailability;

public interface PhysicianAvailabilityRepo extends JpaRepository<PhysicianAvailability,String> {

	public List<PhysicianAvailability> findByIsAvailable(boolean isAvailable);
	
    public String deleteByEmail(String email);
    
    @Modifying
    @Query(value = "UPDATE PHYSICIAN_AVAILABILITY SET physician_available_from=:startDate , physician_available_till=:endDate WHERE physician_email=:email",nativeQuery = true)
    public void updateStartAndEndDate(@Param(value = "startDate")String startDate,@Param(value = "endDate")String endDate,@Param(value = "email")String email);

}	
