package com.athira.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.ConsultationNote;

@Repository
public interface IConsultationNoteDao extends JpaRepository<ConsultationNote, Integer> {

	@Procedure("spCreateConsultationNotes")
	ConsultationNote spCreateConsultationNotes(Integer appointmentId, String symptoms, String diagnosis,
			String followUp);

	@Procedure("spGetConsultationNotesByPatientId")
	List<ConsultationNote> spGetConsultationNotesByPatientId(Integer patientId);

}
