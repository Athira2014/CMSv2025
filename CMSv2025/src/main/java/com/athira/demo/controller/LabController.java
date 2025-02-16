package com.athira.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.dto.LabTestPrescriptionDto;
import com.athira.demo.entity.LabTest;
import com.athira.demo.entity.LabTestCategory;
import com.athira.demo.entity.LabTestDetails;
import com.athira.demo.entity.LabTestPrescription;
import com.athira.demo.entity.LabTestResult;
import com.athira.demo.service.ILabTestService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class LabController {

	@Autowired
	ILabTestService labTestService;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("labTests")
	public List<LabTest> getAllLabTests() {
		return labTestService.getAllLabTests();
	}

	@GetMapping("labTestCategories")
	public List<LabTestCategory> getAllLabTestCategories() {
		return labTestService.getAllLabTestCategories();
	}

	@GetMapping("labTestDetails")
	public List<LabTestDetails> getAllLabTestDetails() {
		return labTestService.getAllLabTestDetails();
	}

	@GetMapping("labtestresults")
	public List<LabTestResult> getAllLabTestResults() {
		return labTestService.getAllLabTestResults();
	}

	@GetMapping("labtestresults/{detailId}")
	public List<LabTestResult> getLabTestResultsByDetailsId(@PathVariable Integer detailId) {
		return labTestService.getLabTestResultsByDetailsId(detailId);
	}

	// create lab Test Categories
	@PostMapping("labTestCategories")
	public ResponseEntity<APIResponse> addlabTestCategories(@RequestBody LabTestCategory labTestCategory,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestCategory labTestCategoryEntity = labTestService.savelabTestCategories(labTestCategory);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestCategoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// update lab Test Categories
	@PutMapping("labTestCategories")
	public ResponseEntity<APIResponse> updatelabTestCategories(@RequestBody LabTestCategory labTestCategory,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestCategory labTestCategoryEntity = labTestService.updatelabTestCategories(labTestCategory);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestCategoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Disable lab Test Categories
	@DeleteMapping("labTestCategories/{id}")
	public ResponseEntity<APIResponse> disableLabTestCategories(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestCategory labTestCategoryEntity = labTestService.disableLabTestCategories(id);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestCategoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create lab Test
	@PostMapping("labTests")
	public ResponseEntity<APIResponse> addlabTests(@RequestBody LabTest labTest,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTest labTestEntity = labTestService.savelabTests(labTest);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

//	// update lab Test
//	@PostMapping("labTests")
//	public ResponseEntity<APIResponse> updatelabTestCategories(@RequestBody LabTest labTest) {
//
//		APIResponse apiResponse = new APIResponse();
//
//		try {
//			LabTest labTestEntity = labTestService.updatelabTests(labTest);
//			apiResponse.setStatus(200);
//			apiResponse.setData(labTestEntity);
//
//		} catch (Exception e) {
//			apiResponse.setStatus(500);
//			apiResponse.setError(e.getMessage());
//		}
//
//		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//	}

	// Disable lab Test
	@DeleteMapping("labTests/{id}")
	public ResponseEntity<APIResponse> disableLabTest(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTest labTestEntity = labTestService.disableLabTest(id);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create lab test prescriptions
	@PostMapping("labtestprescription")
	public ResponseEntity<APIResponse> addLabTestPrescription(
			@RequestBody LabTestPrescriptionDto labTestPrescriptionDto,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestPrescription labTestPrescription = labTestPrescriptionDto.getLabTestPrescription();
			List<Integer> labTestIds = labTestPrescriptionDto.getLabTestIds();
			LabTestPrescription labTestPrescriptionEntity = labTestService.addLabTestPrescription(labTestPrescription,
					labTestIds);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestPrescriptionEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update lab test prescriptions
	@PutMapping("labtestprescription")
	public ResponseEntity<APIResponse> updateLabTestPrescription(
			@RequestBody LabTestPrescriptionDto labTestPrescriptionDto) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestPrescription labTestPrescription = labTestPrescriptionDto.getLabTestPrescription();
			List<Integer> labTestIds = labTestPrescriptionDto.getLabTestIds();
			LabTestPrescription labTestPrescriptionEntity = labTestService.addLabTestPrescription(labTestPrescription,
					labTestIds);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestPrescriptionEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping("labTestDetails")
	public ResponseEntity<APIResponse> addLabTestDetails(@RequestBody LabTestDetails labTestDetails,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestDetails labTestDetailsEntity = labTestService.addLabTestDetails(labTestDetails);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestDetailsEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PutMapping("labTestDetails")
	public ResponseEntity<APIResponse> updateLabTestDetails(@RequestBody LabTestDetails labTestDetails,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestDetails labTestDetailsEntity = labTestService.updateLabTestDetails(labTestDetails);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestDetailsEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping("labtestresults")
	public ResponseEntity<APIResponse> addLabTestResults(@RequestBody LabTestResult labTestResult,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			LabTestResult labTestResultEntity = labTestService.addLabTestResults(labTestResult);
			apiResponse.setStatus(200);
			apiResponse.setData(labTestResultEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
