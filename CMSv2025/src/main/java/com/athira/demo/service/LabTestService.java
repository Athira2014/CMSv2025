package com.athira.demo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.ILabTestCategoryDao;
import com.athira.demo.dao.ILabTestDao;
import com.athira.demo.dao.ILabTestDetailsDao;
import com.athira.demo.dao.ILabTestPrescriptionDao;
import com.athira.demo.dao.ILabTestResultDao;
import com.athira.demo.entity.LabTest;
import com.athira.demo.entity.LabTestCategory;
import com.athira.demo.entity.LabTestDetails;
import com.athira.demo.entity.LabTestPrescription;
import com.athira.demo.entity.LabTestResult;

@Transactional
@Service
public class LabTestService implements ILabTestService {

	private static final Logger logger = LoggerFactory.getLogger(LabTestService.class);

	@Autowired
	ILabTestDao labTestDao;

	@Autowired
	ILabTestCategoryDao labTestCategoryDao;

	@Autowired
	ILabTestDetailsDao labTestDetailsDao;

	@Autowired
	ILabTestPrescriptionDao labTestPrescriptionDao;
	

	@Autowired
	ILabTestResultDao labTestResultDao;

	public List<LabTest> getAllLabTests() {
		return labTestDao.findAll();
	}

	@Transactional
	public List<LabTestCategory> getAllLabTestCategories() {
		return labTestCategoryDao.findAll();
	}

	@Transactional
	public List<LabTestDetails> getAllLabTestDetails() {
		return labTestDetailsDao.findAll();
	}

	public LabTestCategory savelabTestCategories(LabTestCategory labTestCategory) {

		Timestamp createdDate = (Timestamp) (labTestCategory.getCreatedDate() != null ? labTestCategory.getCreatedDate()
				: new Timestamp(System.currentTimeMillis()));

		return labTestCategoryDao.spAddNewLabTestCategory(labTestCategory.getCategory(), createdDate,
				labTestCategory.isActive());
	}

	public LabTestCategory updatelabTestCategories(LabTestCategory labTestCategory) {
		return labTestCategoryDao.save(labTestCategory);
	}

	public LabTestCategory disableLabTestCategories(Integer id) {
		return labTestCategoryDao.disableLabTestCategories(id);
	}

	public LabTest savelabTests(LabTest labTest) {

		DateTime createdDateTime = labTest.getCreatedDate();
		// If createdDate is not set (new test), use current date
		if (createdDateTime == null) {
			createdDateTime = new DateTime(); // Or some default value
		}

		try {
			return labTestDao.spAddNewLabTests(labTest.getLabTestCatId(), labTest.getTestName(),
					labTest.getDescription(), labTest.getParameters(), createdDateTime, true);
		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for LabTest: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while adding LabTest: {}", e.getMessage());
			throw new IllegalArgumentException("Data access exception occured while adding new lab tests");
		} catch (Exception e) {
			logger.error("Unexpected error while adding LabTest: {}", e.getMessage());
			throw new IllegalArgumentException("Unexpected exception occured while adding new lab tests");
		}
	}

	public LabTest updatelabTests(LabTest labTest) {

		try {
			
			return labTestDao.spUpdateLabTests(labTest.getLabTestCatId(), labTest.getTestName(), labTest.getDescription(),
					labTest.getParameters(), labTest.getLabTestsId(), labTest.getCreatedDate(), labTest.isActive());
		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for LabTest: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while updating LabTest: {}", e.getMessage());
			throw new RuntimeException("Data access exception occurred while updating lab tests", e);
		} catch (Exception e) {
			logger.error("Unexpected error while updating LabTest: {}", e.getMessage());
			throw new RuntimeException("Unexpected error occurred while updating lab tests", e);
		}
	}

	public LabTest disableLabTest(Integer id) {
		return labTestDao.disableLabTest(id);
	}

	public LabTestPrescription addLabTestPrescription(LabTestPrescription labTestPrescription, List<Integer> labTestIds) {
	    
		if (labTestPrescription == null) {
	        throw new IllegalArgumentException("LabTestPrescription cannot be null");
	    }
	    
	    if (labTestIds == null || labTestIds.isEmpty()) {
	        throw new IllegalArgumentException("LabTest IDs cannot be null or empty");
	    }

	    try {
	        //first Save the LabTestPrescription
	        LabTestPrescription prescription = labTestPrescriptionDao.save(labTestPrescription);

	        // Fetch the LabTest entities by their IDs
	        List<LabTest> labTests = labTestDao.findAllById(labTestIds);
	        
	        // throw error if any LabTest was not found
	        if (labTests.size() != labTestIds.size()) {
	            throw new IllegalArgumentException("Some LabTest IDs are invalid or not found");
	        }

	        prescription.setLabTests(labTests);

	        // Save and return the updated LabTestPrescription
	        return labTestPrescriptionDao.save(prescription);

	    } catch (DataIntegrityViolationException e) {
	        // Handle database-related integrity violations
	        throw new RuntimeException("Error saving LabTestPrescription due to data integrity violation", e);
	    } catch (ConstraintViolationException e) {
	        // Handle constraint violation errors
	        throw new RuntimeException("Error saving LabTestPrescription due to constraint violation", e);
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred while adding LabTestPrescription", e);
	    }
	}

	public LabTestDetails addLabTestDetails(LabTestDetails labTestDetails) {

	    try {
	    	Timestamp createdDate =  new Timestamp(System.currentTimeMillis());
	    	
	        // Save and return the updated LabTestDetails
	        return labTestDetailsDao.spCreateLabTestDetails(labTestDetails.getLabPrescId(), createdDate, 
	        		labTestDetails.getRemarks(), true);

	    } catch (DataIntegrityViolationException e) {
	        // Handle database-related integrity violations
	        throw new RuntimeException("Error saving LabTestDetails due to data integrity violation", e);
	    } catch (ConstraintViolationException e) {
	        // Handle constraint violation errors
	        throw new RuntimeException("Error saving LabTestDetails due to constraint violation", e);
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred while adding LabTestDetails", e);
	    }
	}

	public LabTestDetails updateLabTestDetails(LabTestDetails labTestDetails) {

		Optional<LabTestDetails> existing = labTestDetailsDao.findById(labTestDetails.getLabTestDetId());
		if(!existing.isPresent()) {
			throw new IllegalArgumentException("Invalid lab test detail id.");
		}
		
		LabTestDetails existingLabTestDetails = existing.get();
		if(labTestDetails.getLabPrescId() != null) {
			existingLabTestDetails.setLabPrescId(labTestDetails.getLabPrescId());
		}
		
		if(labTestDetails.getRemarks() != null) {
			existingLabTestDetails.setRemarks(labTestDetails.getRemarks());
		}
		if(labTestDetails.isActive() != null) {
			existingLabTestDetails.setActive(labTestDetails.isActive());
		}
		return labTestDetailsDao.save(existingLabTestDetails);
	}

	public List<LabTestResult> getAllLabTestResults() {
		return labTestResultDao.findAll();
	}

	public List<LabTestResult> getLabTestResultsByDetailsId(Integer detailId) {
		return labTestResultDao.findByLabTestDetId(detailId);
	}

	public LabTestResult addLabTestResults(LabTestResult labTestResult) {
		
		Timestamp createdDate =  new Timestamp(System.currentTimeMillis());
		
		return labTestResultDao.spCreateLabTestResult(labTestResult.getLabTestDetId(), labTestResult.getDescription(),
				labTestResult.getResult(), labTestResult.getFlag(), createdDate, true);
	}

}
