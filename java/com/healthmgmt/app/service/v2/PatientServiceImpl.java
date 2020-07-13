package com.healthmgmt.app.service.v2;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthmgmt.app.entity.v2.GetPatientResponse;
import com.healthmgmt.app.entity.v2.Patient;

import com.healthmgmt.app.dao.v2.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	
	private static final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);
	@Autowired
	PatientRepository patientRepository;

	public void createPatient(Patient patient) {

		patientRepository.save(patient);
	}

	 
	public GetPatientResponse getAllPatient() {

		GetPatientResponse patietData = new GetPatientResponse();
		patietData.setPatients((List<Patient>) patientRepository.findAll());
		return patietData;
	}
	
	public void update(Patient newPatient, long id) {

		Optional<Patient> patient = patientRepository.findById(id);
		Patient ptn = new Patient();
		if (patient != null && patient.isPresent()) {
			ptn.setName(newPatient.getName());
			ptn.setMobile(newPatient.getMobile());
			ptn.setId(newPatient.getId());
			patientRepository.save(ptn);
		}

	}

	public void deletePatientById(long id) {
		patientRepository.deleteById(id);
	}

//  RB ref: ProductService 
	public List<Patient> listAll() {
        return patientRepository.findAll();
    }
	
//    RB ref: ProductService 
	public Optional<Patient> findPatientById(long id) {
		return patientRepository.findById(id);
	}
	
//	    RB ref: ProductService
	 public void save(Patient patient) {
	    	//System.out.println("ProductService.save() Saving the product :"+product.getId());
		 log.info("Saving the patient name:", patient.getName());
		 
		 patientRepository.save(patient);
	    }
	     
	 public Patient findById(long id) {
	        return patientRepository.findById(id).get();
	    }
		
	   

}

