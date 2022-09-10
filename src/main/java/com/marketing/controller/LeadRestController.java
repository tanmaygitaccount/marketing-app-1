package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@RestController                    //it will interact web service with services layer 
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadService leadService;
	
	@GetMapping                    //it will take the all data from the database and it will puts into JSON object
	public List<Lead> getAllLeads() {
		
		List<Lead> leads = leadService.listLeads();
		
		return leads;
		
	}
	    
	//save record in database
	
	@PostMapping                   //use this annotation in webServices when you want to save the data into database
	public void saveOneLead(@RequestBody Lead lead) {   // from the url it will take data & puts that in lead object which is java object &stored into db
		leadService.saveLead(lead);
		
	}
	
	//delete record from database

	@DeleteMapping("/delete/{id}")    //delete by using id number
	public void deleteOneLead(@PathVariable("id") long id) {  //to read the data/variable from url we use @PathVariable in WebServices
		leadService.deleteLeadById(id);
	}
	
	//update the record 
	
	@PutMapping                   //use this annotation in webServices for update the data
	public void updateOneLead(@RequestBody Lead lead) {   
		leadService.saveLead(lead);
	}
	
	@GetMapping("/lead/{id}")     //for calling this method use url localhost:8080/api/leads/lead/{id no.} whichever id u want that hv to put id numberr
	public Lead getOneLead(@PathVariable("id") long id ) {
		Lead lead = leadService.getOneLead(id);
		return lead;
	}
	
}
