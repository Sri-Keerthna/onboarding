package com.spiralforge.onboarding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiralforge.onboarding.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer>{

	Optional<Salary> findByDesignation(String designation);

}
