package com.spiralforge.onboarding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiralforge.onboarding.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findAllByEmployeeStatus(String pendingStatus);

	Employee findByMobileNumberAndPassword(Long mobileNumber, String password);

}
