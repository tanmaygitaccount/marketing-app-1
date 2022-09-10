package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead); //we are going to supply Lead(Entity class) object address and its stored in lead

	public List<Lead> listLeads();  //if there how much no.of records available in table, that all it will return record
	                                //that all Leads object are stored in 'List'

	public void deleteLeadById(long id);

	public Lead getOneLead(long id);

}
