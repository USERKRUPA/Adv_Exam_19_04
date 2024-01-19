package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.JobPostingDto;

public interface JobPostingService {
		//add new job to job_postings table
		String addNewJobPosting(@Valid JobPostingDto newJobPostingDto);

		//get all job postings
		List<JobPostingDto> getAllJobPostings();

		//update jobPosting for given jobId
		String updateJobPosting(Long jobId,JobPostingDto updateJobPostingDto);

		//delete jobPosting of given jobId
		String removeJobPosting(Long jobId);
}
