package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.BloodDonor;
import com.klef.soa.repository.BloodDonorRepository;

@Service
public class BloodDonorServiceImpl implements BloodDonorService
{
	@Autowired
	private BloodDonorRepository repo;

	@Override
	public BloodDonor addBloodDnor(BloodDonor donor) 
	{
		return repo.save(donor);
	}

	@Override
	public List<BloodDonor> displayAllBloodDonors() 
	{
		return repo.findAll();
	}

	@Override
	public BloodDonor updateBloodDonor(BloodDonor b) 
	{
		Optional<BloodDonor> optional = repo.findById(b.getBloodDonorId());

		if(optional.isPresent())
		{
			BloodDonor bloodDonor = optional.get();
			
			bloodDonor.setName(b.getName());
			bloodDonor.setType(b.getType());
			bloodDonor.setStatus(b.isStatus());
			bloodDonor.setLocation(b.getLocation());
			
			return repo.save(bloodDonor);
		}
		else
		{
			return null;
		}
	}

	@Override
	public BloodDonor displayBloodDonorById(Long bloodDonorId) 
	{
		return repo.findById(bloodDonorId).orElse(null);

	}

	@Override
	public String deleteBloodDonorById(Long bloodDonorId) 
	{
		boolean status = repo.existsById(bloodDonorId);
		if(status)
		{
			repo.deleteById(bloodDonorId);
			return "bloodDonor Deleted Successfully";
		}
		else
		{
			return "bloodDonor ID Not Found";
		}
	}

	

	@Override
	public List<BloodDonor> displayDonorsByName(String name) 
	{
		return repo.findByName(name);
	}

	@Override
	public List<BloodDonor> displayDonorsByType(String type) 
	{
		return repo.findByType(type);
	}

	
	
}
