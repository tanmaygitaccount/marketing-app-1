package com.marketing.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;


@Controller               //with this annotation it will identify that is as controller layer in spring boot
public class LeadController {
	
	//here we are creating reference variable of Interface& creating object of LeadSeriveImpl and inject its address into it
	@Autowired
	private LeadService leadService;
	
	//Handler method
	@RequestMapping("/createLead")                   //its working as like servlet & it get call from front end url
	public String viewCreateLeadPage() {
		return "create_lead";                       //its working as like requestDispacture for calling jsp
	}
	@RequestMapping("/saveLead") 
	public String saveOneLead(@ModelAttribute ("lead") Lead lead , ModelMap model) {   //here Lead is entity class of object
		leadService.saveLead(lead);                               //calling to services layer
		model.addAttribute("msg","Lead is saved!");               // for showing data is save in frontEnd
		return "create_lead";
	}
	
	@RequestMapping("/listall")                      //go to frontEnd and search'listall'
	public String listAllLeads(ModelMap model) {    //we are creating this method for display table(object data whatever we stored in db in front end
		
		 List<Lead> leads = leadService.listLeads();
		 model.addAttribute("leads", leads);
		 return "lead_search_results";
		 
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id , ModelMap model) {
		
		leadService.deleteLeadById(id);               // for delete we have to  create new method for coding
		
		 List<Lead> leads = leadService.listLeads();  //after the read the data we want same page will be open in front end
		 model.addAttribute("leads", leads);          //- soo we copying as it is above code
		 return "lead_search_results";
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id , ModelMap model ) {
		
		Lead lead = leadService.getOneLead(id);   
		
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLeadData(LeadData data , ModelMap model) {  //use DTO method for reading the data(data transfer object )
		
		Lead lead=new Lead();          //Entity class only interact with database soo create entity class object 
		
		lead.setId(data.getId());
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());
		
		leadService.saveLead(lead);
		
		 List<Lead> leads = leadService.listLeads();
		 model.addAttribute("leads", leads);
		 return "lead_search_results";
		
	}
	
	
}
