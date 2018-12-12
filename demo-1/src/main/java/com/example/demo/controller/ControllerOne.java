package com.example.demo.controller;

import java.util.List;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Details;
import com.example.demo.service.ServiceDetails;

@RestController
public class ControllerOne {
	@Inject
	private ServiceDetails serviceDetails;
	
	@GetMapping("/hi")
	public String hello()
	{
		return "hello";
	}
	
	@PostMapping(value= "/details")
	public void postDetails(@RequestBody Details details)
	{
		serviceDetails.addDetails(details);
	}
	
	@GetMapping("/details/get")
	public Details findDetails()
	{
	return serviceDetails.findAll();	
	}
	
	@GetMapping("/specificDetails")
	public String getSpecificDetails()
	{
		return serviceDetails.getSpecificDetails();
	}
	
	@GetMapping("/domain")
	public String getMeDomain()
	{
		return serviceDetails.getDomain();
	}

}
