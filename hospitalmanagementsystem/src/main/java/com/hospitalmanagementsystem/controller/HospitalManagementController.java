package com.hospitalmanagementsystem.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagementsystem.exceptions.ResourceNotFoundException;
import com.hospitalmanagementsystem.model.HospitalManagement;
import com.hospitalmangementsystem.repository.HospitalManagementRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HospitalManagementController{
@Autowired(required=true)
private HospitalManagementRepository HospitalManagementRepository;

@GetMapping("/Appoinments")
public List<HospitalManagement> getAllHospitalManagement() {
	return HospitalManagementRepository.findAll();
}

@GetMapping("/Appoinments/{Name}")
public ResponseEntity<HospitalManagement> getHospitalManagementByName(@PathVariable(value = "Name") String HospitalManagementName)
		throws ResourceNotFoundException {
	HospitalManagement HospitalManagement = HospitalManagementRepository.findById(HospitalManagementName)
			.orElseThrow(() -> new ResourceNotFoundException("Patients not found for this Name :: " + HospitalManagementName));
	return ResponseEntity.ok().body(HospitalManagement);
}

@PostMapping("/Appoinments")
public HospitalManagement createHospitalManagement(@Validated @RequestBody HospitalManagement HospitalManagement) {
	return HospitalManagementRepository.save(HospitalManagement);
}

@PutMapping("/Appoinments/{Name}")
public ResponseEntity<HospitalManagement> updateHospitalManagement(@PathVariable(value = "Name") String HospitalManagementName,
		@Validated @RequestBody HospitalManagement HospitalManagementDetails) throws ResourceNotFoundException {
	HospitalManagement HospitalManagement =HospitalManagementRepository.findById(HospitalManagementName)
			.orElseThrow(() -> new ResourceNotFoundException("Patients not found for this Name :: " + HospitalManagementName));

	HospitalManagement.setEmailId(HospitalManagementDetails.getEmailId());
	HospitalManagement.setDoctorName(HospitalManagementDetails.getDoctorName());
	HospitalManagement.setName(HospitalManagementDetails.getName());
	HospitalManagement.setDepartments(HospitalManagement.getDepartments());
	HospitalManagement.setTime(HospitalManagement.getTime());
	final HospitalManagement updatedHospitalManagement = HospitalManagementRepository.save(HospitalManagement);
	return ResponseEntity.ok(updatedHospitalManagement);
}

@DeleteMapping("/Appoinments/{Name}")
public Map<String, Boolean> deleteHospitalManagement(@PathVariable(value = "Name") String HospitalManagementName)
		throws ResourceNotFoundException {
	HospitalManagement HospitalManagement = HospitalManagementRepository.findById(HospitalManagementName)
			.orElseThrow(() -> new ResourceNotFoundException("Patients not found for this Name :: " + HospitalManagementName));

	HospitalManagementRepository.delete(HospitalManagement);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
}
}