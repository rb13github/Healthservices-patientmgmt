package com.healthmgmt.app.service.v2;

import java.util.List;
import java.util.Optional;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.v2.GetPatientResponse;
import com.healthmgmt.app.entity.v2.Patient;


public interface PatientService {
	
	public void createPatient(Patient patient);
		
	public GetPatientResponse getAllPatient();
	
	public Optional<Patient> findPatientById(long id);
	
	
	public void save(Patient patient);

	public Patient findById(long id) ;
	
	public void update(Patient patient, long id);
	
	public void deletePatientById(long id);
	
	public List<Patient> listAll();
	
}

