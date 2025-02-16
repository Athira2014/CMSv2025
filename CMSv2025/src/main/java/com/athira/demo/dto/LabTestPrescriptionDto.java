package com.athira.demo.dto;

import java.util.List;

import com.athira.demo.entity.LabTestPrescription;

public class LabTestPrescriptionDto {
	private LabTestPrescription labTestPrescription;
    private List<Integer> labTestIds;

    // Getters and setters
    public LabTestPrescription getLabTestPrescription() {
        return labTestPrescription;
    }

    public void setLabTestPrescription(LabTestPrescription labTestPrescription) {
        this.labTestPrescription = labTestPrescription;
    }

    public List<Integer> getLabTestIds() {
        return labTestIds;
    }

    public void setLabTestIds(List<Integer> labTestIds) {
        this.labTestIds = labTestIds;
    }
}
