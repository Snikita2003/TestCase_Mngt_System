package com.tc.services;
import java.util.*;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tc.model.TestCase;
import com.tc.model.TestCaseDto;

import jakarta.annotation.Priority;
import jakarta.transaction.Status;


public interface TestCaseService {
	
	
	public List<TestCaseDto> getAllTestCases( String status, String priority  );
	public TestCaseDto getTestcaseById(int id);
	public TestCaseDto createTestCase(TestCaseDto tc);
	public TestCaseDto updateTCById(int id, TestCaseDto newTc );
	public void deleteById(int id);
	public List<TestCaseDto> storeTestCases(List<TestCaseDto> data );
	public List<TestCaseDto> getAllTestCases(int no,int size);
	
	
	
	
	

}
