package com.example.demo.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.beans.Details;

import com.example.demo.domain.Domain;
import com.example.demo.domain.DomainRepository;

@Service
public class ServiceDetails {
	
	@Autowired
	private DomainRepository domainRepository;
	@Inject
	private Domain domain;
	@PersistenceContext
    private EntityManager entityManager;
//	public Iterable<Details> findAll()
//	{
//		return domainRepository.findAll();
//	}
	
	public void addDetails(Details details)
	{
		domainRepository.save(details);
	}
	
	public String getSpecificDetails()
	{
		//return domainRepository.getSpecificDetails();
		return "inservice";
	}
	
	public String getDomain()
	{
		return domain.printMe();
	}
	 @Value("100")
		public void valuePractise(int value,@Value("200") int value2)
		{
			System.out.println(value);
			System.out.println(value2);
		}
	
	 
	 @Transactional
		public Details findAll() {
			//em.getTransaction().begin();
			Details d = entityManager.find(Details.class, "11521174");
			//em.getTransaction().commit();

			return d;
		}
//	 EntityTransaction entTrans = entityManager.getTransaction();
//	 entTrans.begin();
//	 entityManager.persist( pe );
//	 entTrans.commit();
	
}
