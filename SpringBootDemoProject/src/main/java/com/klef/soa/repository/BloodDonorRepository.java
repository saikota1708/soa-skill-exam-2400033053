package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.BloodDonor;

@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long>
{
	//from BloodDonor b where b.name=?1
	List<BloodDonor> findByName(String name);
	List<BloodDonor> findByType(String type);
}
