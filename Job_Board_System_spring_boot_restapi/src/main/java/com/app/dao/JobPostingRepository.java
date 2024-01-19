package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long>{

	
}