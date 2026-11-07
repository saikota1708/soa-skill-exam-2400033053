package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.BloodDonor;

public interface BloodDonorService 
{
	BloodDonor addBloodDnor(BloodDonor donor);
	List<BloodDonor> displayAllBloodDonors();
	BloodDonor updateBloodDonor(BloodDonor d);
	BloodDonor displayBloodDonorById(Long bloodDonorId);
	String deleteBloodDonorById(Long bloodDonorId);
	
	List<BloodDonor> displayDonorsByName(String name);
	List<BloodDonor> displayDonorsByType(String type);
}
