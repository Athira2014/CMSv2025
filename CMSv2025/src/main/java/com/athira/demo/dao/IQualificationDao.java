package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Qualification;

@Repository
public interface IQualificationDao extends JpaRepository<Qualification, Integer> {

}
