package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;

@Service    //it Annotation is mandatory in springBoot for identify services layer
public class LeadServiceImpl implements LeadService {

	//we are calling Repository layer so we create the object of repository layer
	@Autowired
	public LeadRepository leadRepo;  
	
	@Override
	public void saveLead(Lead lead) {  //while calling this method will supply Lead object address to lead and In LeadRepository it save
		leadRepo.save(lead);           //it will stored the data in database with the help of Repository

	}

	@Override
	public List<Lead> listLeads() {  //for list of leads from database
        List<Lead> leads = leadRepo.findAll();  //assign
		
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get(); 
		
		return lead;
	}

}
