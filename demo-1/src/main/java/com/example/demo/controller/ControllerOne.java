package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Details;
import com.example.demo.service.ServiceDetails;

@RestController
public class ControllerOne {
	@Autowired
	private ServiceDetails serviceDetails;
	
	@RequestMapping("/hi")
	public String hello()
	{
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.POST ,value= "/details")
	public void postDetails(@RequestBody Details details)
	{
		serviceDetails.addDetails(details);
	}
	
	@RequestMapping("/details")
	public Iterable<Details> findDetails()
	{
	return serviceDetails.findAll();	
	}
	
	@RequestMapping("/specificDetails")
	public List<Object> getSpecificDetails()
	{
		return serviceDetails.getSpecificDetails();
	}

}
