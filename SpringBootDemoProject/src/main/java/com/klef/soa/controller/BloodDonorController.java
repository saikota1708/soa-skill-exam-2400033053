package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.BloodDonor;
import com.klef.soa.service.BloodDonorService;

@RestController
@RequestMapping("/donor")
public class BloodDonorController 
{
	@Autowired
	private BloodDonorService service;
	
	@GetMapping("/")
	public String test()
	{
		return "SOA Programming & MicroServices";
	}
	
	@PostMapping("/add") 
	public ResponseEntity<BloodDonor> addBloodDonor(@RequestBody BloodDonor d) 
	{ 
		BloodDonor bd = service.addBloodDnor(d); 
		return ResponseEntity.status(201).body(bd); 
	}
	
	@GetMapping("/displayall")
	public ResponseEntity<List<BloodDonor>> displayAllBloodDonors()
	{
		List<BloodDonor> donors = service.displayAllBloodDonors(); 
		return ResponseEntity.status(200).body(donors);
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayBloodDonorById(@RequestParam Long bloodDonorId)
	{
		BloodDonor donor = service.displayBloodDonorById(bloodDonorId);

		if(donor != null)
		{
			return ResponseEntity.status(200).body(donor);
		}
		else
		{
			return ResponseEntity.status(404).body("Patient ID Not Found");
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateBloodDonor(@RequestBody BloodDonor donor)
	{
		BloodDonor d = service.updateBloodDonor(donor);

		if(d != null)
		{
			return ResponseEntity.ok(d);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BloodDonor ID Not Found");
		}
	}
	
	@DeleteMapping("/delete/{bloodDonorId}")
	public ResponseEntity<String> deleteBloodDonorById(@PathVariable Long bloodDonorId)
	{
		String message = service.deleteBloodDonorById(bloodDonorId);
        return new ResponseEntity<>(message, HttpStatus.OK);	
	}
	
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<BloodDonor>> displayDonorsByName(@PathVariable String name)
	{
		List<BloodDonor> donors = service.displayDonorsByName(name);
		return ResponseEntity.status(200).body(donors);
	}
	
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<BloodDonor>> displayDonorsByType(@PathVariable String type)
	{
		List<BloodDonor> donors = service.displayDonorsByType(type);
		return ResponseEntity.status(200).body(donors);
	}
}
