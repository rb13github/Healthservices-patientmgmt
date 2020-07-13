package com.healthmgmt.app.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.healthmgmt.app.entity.v2.Patient;
import com.healthmgmt.app.service.v2.PatientService;
import com.healthmgmt.app.service.v2.PatientServiceImpl;


//import io.swagger.annotations.Api;

//@RestController  //RB: as instead of API ,view to be shown on UI
@Controller
@CrossOrigin(origins="*")
@RequestMapping(value={"/","/healthmgmt/patient"})
//RB://RB: as instead of API ,view to be shown on UI
//@Api(value="sample", description="Sample SpringBoot CRUD Application with MongoDB")
public class PatientController {
	
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	 @Value("${greeter.message}")
	    private String greeterMessageProperty; 
	 
	@Autowired
	PatientService patientService;
///RB: commented to not use Rest API
//	 @PostMapping(value="/create/patient",headers="Accept=application/json")
//	 public ResponseEntity<Void> createPatient(@RequestBody Patient patient, UriComponentsBuilder ucBuilder){
//	     patientService.createPatient(patient);
//	     HttpHeaders headers = new HttpHeaders();
//	     headers.setLocation(ucBuilder.path("/patient/{name}").buildAndExpand(patient.getName()).toUri());
//	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	 }
//
//	 @GetMapping(value="/get/patient", headers="Accept=application/json")
//	 public GetPatientResponse getAllPatient() {		 
//		GetPatientResponse patientList = patientService.getAllPatient();
//		return patientList;
//	 }
//	 
//	 @GetMapping(value="/get/patient/{id}", headers="accept=application/json")
//	 public Optional<Patient> findPatientById(@PathVariable("id") Long id){
//		 Optional<Patient> patient= patientService.findPatientById(id);
//		 return patient;
//	 }
//
//	
//	  @PutMapping(value="/update/patient/{id}", headers="Accept=application/json") 
//	  public ResponseEntity<Patient> updatePatient(@RequestBody Patient currentPatient,@PathVariable("id") String name) {
//		  patientService.update(currentPatient, name);
//		  return new ResponseEntity<Patient>(HttpStatus.OK); 
//	  }
//	  
//	  @DeleteMapping(value="/delete/patient/{id}", headers ="Accept=application/json") 
//	  public ResponseEntity<Patient> deletePatient(@PathVariable("id") Long id){
//		  Optional<Patient> patient = patientService.findPatientById(id);
//		  if (patient == null) { 
//			  return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND); 
//		  } 
//		  patientService.deletePatientById(id);
//		  return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT); 
//	  }
//	 

	 @RequestMapping("/welcome")
	    public String viewPatientswelcomePage(Model model) {
		 
		 System.out.println("greeterMessageProperty   :   "+greeterMessageProperty);
	        
		 if(null!=greeterMessageProperty)
	        {
			 System.out.println("greet prefix from greeterMessageProperty  :   "+greeterMessageProperty); 
	        }
	         
		 
		 String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
	          
	        
	         prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
	        
	        
	        System.out.println("logger classs   :   "+log.getName());
	        
	        if ( null == prefix) {
	            prefix = "Hello!";
	        }
	        
	        model.addAttribute("prefix", prefix);
	        
	        return "welcome_patient";
	        
		 
	 }
	
	
	 @RequestMapping("/getPatients")
	    public String viewPatientsPage(Model model) {
	        List<Patient> listPatients = patientService.listAll();
	        model.addAttribute("listPatients", listPatients);
	        
	       
	        
	        
	       
	       
	        
	        log.warn("listPatients logger  :   "+listPatients);
	         
	        return "fetchPatients";
	    }
	    
	   	    
	    @RequestMapping("/new")
	    public String showNewPatientPage(Model model) {
	    	Patient patient = new Patient();
	        model.addAttribute("patient", patient);
	         
	        return "new_patient";
	    }
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String savePatient(@ModelAttribute("patient") Patient patient) {
	    	
	    	 log.info("save patient   :   "+patient.getMobile());
	    	patientService.save(patient);
	         
	        return "redirect:/healthmgmt/patient/getPatients";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditPatientPage(@PathVariable(name = "id") String id) {
	        ModelAndView mav = new ModelAndView("edit_patient");
	        System.out.println("showEditPatientPage: editing the product with id : "+id);
	       
	        log.info("showEditPatientPage: editing the product with id : "+id);
	        
	        Patient patient = patientService.findById(Integer.parseInt(id));
	        mav.addObject("patient", patient);
	         
	        System.out.println("showEditPatientPage: In  the patient with id : "+patient.getId());
	        return mav;
	    }
	    
	    @RequestMapping("/delete/{id}")
	    public String deletePatient(@PathVariable(name = "id") int id) {
	    	patientService.deletePatientById(id);
	        return "redirect:/healthmgmt/patient/getPatients";       
	    }
}
