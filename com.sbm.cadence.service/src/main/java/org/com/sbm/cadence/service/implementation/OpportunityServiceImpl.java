package org.com.sbm.cadence.service.implementation;

import org.com.sbm.cadence.common.dto.OpportunityDTO;
import org.com.sbm.cadence.common.exceptions.ResourceNotFoundException;
import org.com.sbm.cadence.persistance.repository.OpportunityRepository;
import org.com.sbm.cadence.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OpportunityService")
public class OpportunityServiceImpl extends CRUDServiceImpl<OpportunityRepository, OpportunityDTO> implements OpportunityService {

	@Autowired
	private OpportunityRepository opportunityRepository;

	@Override
	public OpportunityDTO update(OpportunityDTO newOpportunity) throws ResourceNotFoundException {
		OpportunityDTO opportunity = opportunityRepository.findById(newOpportunity.getOpportunityId())
				.orElseThrow(() -> new ResourceNotFoundException("Opportunity not found !!! "));
		
		opportunity.setConfidential(newOpportunity.isConfidential());
		opportunity.setBusinessPartners(newOpportunity.getBusinessPartners());
		opportunity.setCustomer(newOpportunity.getCustomer());
		opportunity.setCustomerAuth(newOpportunity.getCustomerAuth());
		opportunity.setCustomerBudget(newOpportunity.getCustomerBudget());
		opportunity.setCustomerNeed(newOpportunity.getCustomerNeed());
		opportunity.setCustomerTiming(newOpportunity.getCustomerTiming());
		opportunity.setDescription(newOpportunity.getDescription());
		opportunity.setDueDate(newOpportunity.getDueDate());
		opportunity.setExpectedClosingDate(newOpportunity.getExpectedClosingDate());
		opportunity.setOdds(newOpportunity.getOdds());
		opportunity.setOmmsysNumber(newOpportunity.getOmmsysNumber());
		opportunity.setOpportunitySource(newOpportunity.getOpportunitySource());
		opportunity.setOpportunityName(newOpportunity.getOpportunityName());
		opportunity.setOpportunityType(newOpportunity.getOpportunityType());
		opportunity.setOwnerName(newOpportunity.getOwnerName());
		opportunity.setRegion(newOpportunity.getRegion());
		opportunity.setSalesRep(newOpportunity.getSalesRep());
		opportunity.setSBMChannel(newOpportunity.getSBMChannel());
		opportunity.setSBO(newOpportunity.isSBO());
		opportunity.setSboNumber(newOpportunity.getSboNumber());
		opportunity.setSector(newOpportunity.getSector());
		opportunity.setSo(newOpportunity.getSo());
		opportunity.setStatus(newOpportunity.getStatus());
		opportunity.setUsers(newOpportunity.getUsers());
//		opportunity.setUserComments(newOpportunity.getUserComments());
//		opportunity.setOpportunityAttachments(newOpportunity.getOpportunityAttachments());
//		opportunity.setOrder(newOpportunity.getOrder());

		final OpportunityDTO updatedOpportunity = opportunityRepository.save(opportunity);
		
		return updatedOpportunity;
	}

}
