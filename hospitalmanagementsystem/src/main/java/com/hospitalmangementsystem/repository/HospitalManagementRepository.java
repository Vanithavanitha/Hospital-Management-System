package com.hospitalmangementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalmanagementsystem.model.HospitalManagement;

@Repository
public interface HospitalManagementRepository extends JpaRepository<HospitalManagement,String> {


	}

