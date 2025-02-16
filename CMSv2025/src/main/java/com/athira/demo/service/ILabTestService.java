package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.LabTest;
import com.athira.demo.entity.LabTestCategory;
import com.athira.demo.entity.LabTestDetails;
import com.athira.demo.entity.LabTestPrescription;
import com.athira.demo.entity.LabTestResult;

public interface ILabTestService {

	List<LabTest> getAllLabTests();

	List<LabTestCategory> getAllLabTestCategories();
	
	List<com.athira.demo.entity.LabTestDetails> getAllLabTestDetails();

	LabTestCategory savelabTestCategories(LabTestCategory labTestCategory);

	LabTestCategory updatelabTestCategories(LabTestCategory labTestCategory);

	LabTestCategory disableLabTestCategories(Integer id);

	LabTest savelabTests(LabTest labTest);

	LabTest updatelabTests(LabTest labTest);

	LabTest disableLabTest(Integer id);

	LabTestPrescription addLabTestPrescription(LabTestPrescription labTestPrescription, List<Integer> labTestIds);

	LabTestDetails addLabTestDetails(LabTestDetails labTestDetails);

	LabTestDetails updateLabTestDetails(LabTestDetails labTestDetails);

	List<LabTestResult> getAllLabTestResults();

	List<LabTestResult> getLabTestResultsByDetailsId(Integer detailId);

	LabTestResult addLabTestResults(LabTestResult labTestResult);

}
