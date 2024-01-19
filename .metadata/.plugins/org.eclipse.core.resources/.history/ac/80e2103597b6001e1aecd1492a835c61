package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.JobPostingRepository;
import com.app.dto.JobPostingDto;
import com.app.entity.JobPosting;

@Service
@Transactional
public class JobPostingServiceImpl implements JobPostingService {

	@Autowired
	private JobPostingRepository jobPostingRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String addNewJobPosting(JobPostingDto newJobPostingDto) {
		JobPosting newJob = mapper.map(newJobPostingDto, JobPosting.class);
		JobPosting persistentJob = jobPostingRepo.save(newJob);
		if (persistentJob != null)
			return "New job added with id: " + persistentJob.getId();
		return "job not added";
	}

	@Override
	public List<JobPostingDto> getAllJobPostings() {
		List<JobPosting> jobPostings = jobPostingRepo.findAll();
		return jobPostings.stream().map(jobPosting -> mapper.map(jobPosting, JobPostingDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public String updateJobPosting(Long jobId, JobPostingDto updateJobPostingDto) {
	 	JobPosting jobPosting = jobPostingRepo.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job Id is not valid"));
	 	jobPosting.setCompanyName(updateJobPostingDto.getCompanyName());
	 	jobPosting.setDescription(updateJobPostingDto.getDescription());
	 	jobPosting.setJobTitle(updateJobPostingDto.getJobTitle());
	 	jobPosting.setLocation(updateJobPostingDto.getLocation());
	 	jobPosting.setPostingDate(updateJobPostingDto.getPostingDate());
	 	jobPosting.setRequirements(updateJobPostingDto.getRequirements());
	 	jobPosting.setSalary(updateJobPostingDto.getSalary());
	 	jobPosting.setId(jobId);
	 	JobPosting persistentJob = jobPostingRepo.save(jobPosting);
		return "Job posting with id: " + persistentJob.getId() + " updated";
	}

	@Override
	public String removeJobPosting(Long jobId) {
	 	JobPosting jobPosting = jobPostingRepo.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job Id is not valid"));
	 	jobPostingRepo.delete(jobPosting);
		return "Job posting with id: " + jobId + " deleted";
	}

}
