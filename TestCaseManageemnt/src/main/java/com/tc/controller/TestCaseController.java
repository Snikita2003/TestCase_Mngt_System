package com.tc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tc.exceptions.ApiResponce;
import com.tc.model.TestCase;
import com.tc.model.TestCaseDto;
import com.tc.services.TestCaseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

// This RestController is accept all incoming http request from // client.

@RestController
@RequestMapping("/api/testcases")
@Tag(name = "TestCase Management System " ) 

public class TestCaseController {

	@Autowired
	public TestCaseServiceImpl testCaseServiceImpl;

	// get all testcases from table by status & priority
	@Operation(summary = "get all testcases from table by status and priority  ", description = "it is used to get all testcase object")

	@GetMapping
	public ResponseEntity<List<TestCaseDto>> getAllTestCases(
	        @RequestParam(required = false) String status,
	        @RequestParam(required = false) String priority) {

	    List<TestCaseDto> testCases = testCaseServiceImpl.getAllTestCases(status, priority);
	    return ResponseEntity.ok(testCases);
	}


	
	
	
	
	// get tc by id
	@Operation(summary = "get testcase by given id ", description = "it is used to get testcase object by id ")
	@GetMapping("/{id}")
	public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Integer id) {

		return new ResponseEntity<TestCaseDto>(this.testCaseServiceImpl.getTestcaseById(id), HttpStatus.OK);

	}

	
	
	
	
	
	// Create / save new Testcase object in table
	@Operation(summary = "Create new Testcase Object ", description = "it is used to create testcase object")
	@PostMapping
	public ResponseEntity<TestCaseDto> createTestCase(@RequestBody TestCaseDto testCase) {
		return ResponseEntity.ok(this.testCaseServiceImpl.createTestCase(testCase));
	}

	
	
	
	
	
	// Update Testcase by id
	@Operation(summary = "update Testcase by id ", description = "it is used to update Testcase object by id ")
	@PutMapping("/{id}")
	public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Integer id, @RequestBody TestCaseDto testCase) {
		return ResponseEntity.ok(this.testCaseServiceImpl.updateTCById(id, testCase));
	}

	
	
	
	
	
	// Delete testcase by id

	@Operation(summary = "delete Testcase by ID ", description = "it is used to delete testcase object by id ")
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponce> deleteTestCase(@PathVariable Integer id) {

		this.testCaseServiceImpl.deleteById(id);

		return new ResponseEntity(new ApiResponce("Deleted Successfully", true), HttpStatus.OK);
	}

	
	
	
	
	
	// create multiple objects of testcases at once go
	@Operation(summary = "Save Multiple Testcases", description = "it is used to save all testcase")
	@PostMapping("/")
	public ResponseEntity<List<TestCaseDto>> StoreAll(@RequestBody List<TestCaseDto> d) {
		return ResponseEntity.ok(this.testCaseServiceImpl.storeTestCases(d));
	}

	
	
	
	
	
	// http://localhost:8080/api/testcases/paginated?page=1&size=10
	// get all testcases by pageno, pageSize
	
	@Operation(summary = "get Testcases by pageNo, pageSize ", description = "it is used to save all testcase")
	@GetMapping("/paginated")
	public List<TestCaseDto> getTastCasesByPagenoAndPageSIze(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		
		return this.testCaseServiceImpl.getAllTestCases(page, size);

	}
	
	
	

}
