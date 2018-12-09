package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Details;
import com.example.demo.domain.DomainRepository;

@Service
public class ServiceDetails {
	
	@Autowired
	private DomainRepository domainRepository;
	
	
	public Iterable<Details> findAll()
	{
		return domainRepository.findAll();
	}
	
	public void addDetails(Details details)
	{
		domainRepository.save(details);
	}
	
	public List<Object> getSpecificDetails()
	{
		return domainRepository.getSpecificDetails();
	}

}
