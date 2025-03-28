package com.tc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tc.exceptions.ResNotFoundExc;
import com.tc.model.TestCase;
import com.tc.model.TestCaseDto;
import com.tc.repos.TCRepo;

import jakarta.annotation.Priority;
import jakarta.transaction.Status;


@Service
public class TestCaseServiceImpl implements TestCaseService {

	
	@Autowired
	private TCRepo tcRepo;
	@Autowired
	private ModelMapper modelmapper;
	
	
	public List<TestCaseDto> getAllTestCases(String status, String priority) {
		
		
		List<TestCase> testCases = this.tcRepo.findByStatusAndPriority(status, priority );
	    
	    return testCases.stream().map(u-> this.modelmapper.map(u, TestCaseDto.class)).collect(Collectors.toList()) ;
	
	}
	

	@Override
	public TestCaseDto getTestcaseById(int id) {
	    TestCase testCase = this.tcRepo.findById(id)
	            .orElseThrow(() -> new ResNotFoundExc("Test Case not found ", id));

	    return this.modelmapper.map(testCase, TestCaseDto.class);
	}

	

	@Override
	public TestCaseDto updateTCById(int id,TestCaseDto newTc) {
		TestCase existingTestCase  =	 this.tcRepo.findById(id).orElseThrow(()->new ResNotFoundExc("Test Case not found ",id));
	
			
		
		// ✅ Update only the changed fields
	    if (newTc.getTitle() != null) existingTestCase.setTitle(newTc.getTitle());
	    if (newTc.getDescription() != null) existingTestCase.setDescription(newTc.getDescription());
	    if (newTc.getPriority() != null) existingTestCase.setPriority(newTc.getPriority());
	    if (newTc.getStatus() != null) existingTestCase.setStatus(newTc.getStatus());

		
	   existingTestCase.setUpdatedAt(new Date());  // ✅ Set updated timestamp

	    tcRepo.save( existingTestCase );
	    return this.modelmapper.map( existingTestCase , TestCaseDto.class);
		
	}

	@Override
	public void deleteById(int id) {
		TestCase existingTestCase  =	 this.tcRepo.findById(id).orElseThrow(()->new ResNotFoundExc("Test Case not found ",id));

		tcRepo.deleteById(id);
		
	}

	@Override
	public List<TestCaseDto> storeTestCases(@RequestBody List<TestCaseDto> data ) {
		
		List<TestCase> testcases=data.stream().map(u-> this.modelmapper.map(u, TestCase.class)).collect(Collectors.toList());
		
		this.tcRepo.saveAll(testcases);
		
		 return data.stream().map(u-> this.modelmapper.map(u, TestCaseDto.class)).collect(Collectors.toList());
	}


	@Override
	public List<TestCaseDto> getAllTestCases(int no, int size) {
		
		Pageable p=PageRequest.of(no, size);
		Page<TestCase> page=this.tcRepo.findAll(p);
		List<TestCase> data=page.getContent();
		
		List<TestCaseDto> testcases=data.stream().map(u-> this.modelmapper.map(u, TestCaseDto.class)).collect(Collectors.toList());
		return testcases;
		
	}


	@Override
	public TestCaseDto createTestCase(TestCaseDto tc) {
		// TODO Auto-generated method stub
		
		tc.setCreatedAt(new Date());  // ✅ Set current timestamp
	    tc.setUpdatedAt(new Date());  // ✅ Set current timestamp
	    TestCase newdata=this.modelmapper.map(tc,TestCase.class);
	    
	    tcRepo.save(newdata);
	    
	    return this.modelmapper.map(newdata, TestCaseDto.class);

	}




}
