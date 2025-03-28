package com.tc.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tc.model.TestCase;
import com.tc.model.TestCaseDto;

import jakarta.annotation.Priority;




@Repository
public interface TCRepo extends JpaRepository<TestCase, Integer > {

	
	public  List<TestCase> findByStatusAndPriority( String s,String p );

	
	
}
