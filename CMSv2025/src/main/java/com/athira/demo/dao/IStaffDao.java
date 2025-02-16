package com.athira.demo.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Staff;

@Repository
public interface IStaffDao extends JpaRepository<Staff, Integer> {

	@Procedure("spListingStaff")
	List<Staff> spListingStaff(Integer roleId, String permission);

	@Procedure("spAddNewStaff")
	Staff spAddNewStaff(String firstName, String lastName, DateTime dob, Integer roleId, String phone,
			String email, DateTime joiningDate, DateTime tillDate, double salary, String status, String address,
			Integer roleId2, String permission);

	@Procedure("spUpdateStaff")
	Staff spUpdateStaff(Integer roleId, String permission, Integer staffId, String firstName, String lastName,
			DateTime dob, Integer roleId2, String phone, String email, DateTime joiningDate, DateTime tillDate,
			double salary, String status, String address);

	@Modifying
	@Query("UPDATE com.athira.demo.entity.Staff SET status = 'INACTIVE' WHERE staffId = :id")
	void disableStaff(@Param("id") Integer id);

	@Procedure("spGetStaffById")
	Staff spGetStaffById(Integer staffid);

	// JPQL query to join User and Staff based on lastLogin being today's date
    @Query("SELECT u.staff FROM User u WHERE u.lastLogin >= :today AND u.lastLogin < :tomorrow")
    List<Staff> getAttendance(@Param("today") DateTime today, @Param("tomorrow") DateTime tomorrow);
}
