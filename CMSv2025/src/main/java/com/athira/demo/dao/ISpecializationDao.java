package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Specialization;

@Repository
public interface ISpecializationDao extends JpaRepository<Specialization, Integer> {

}
