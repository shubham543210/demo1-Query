package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Details;

public interface DomainRepository extends CrudRepository<Details,String> {
	
//	@Query(value="SELECT name FROM details",nativeQuery=true)
//	 List<Object> getSpecificDetails();

}
