package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDto;
import com.app.service.JobPostingService;

@RestController
@RequestMapping("/jobPostings")
public class JobPostingController {

	@Autowired
	private JobPostingService jobPostingService;

	@PostMapping
	public ResponseEntity<?> addNewJob(@RequestBody @Valid JobPostingDto newJobPostingDto) {
		try {
			System.out.println("In add new job");
			String msg = jobPostingService.addNewJobPosting(newJobPostingDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(msg));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllJobPostings() {
		try {
			System.out.println("In get job posting details");
			List<JobPostingDto> jobPostings = jobPostingService.getAllJobPostings();
			if (jobPostings.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok(jobPostings);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}

	}

	@PutMapping("/{jobId}")
	public ResponseEntity<?> updateJobPosting(@PathVariable Long jobId,
			@RequestBody JobPostingDto updateJobPostingDto) {
		try {
			System.out.println("In update job posting");
			String msg = jobPostingService.updateJobPosting(jobId, updateJobPostingDto);
			return ResponseEntity.ok(new ApiResponse(msg));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@DeleteMapping("/{jobId}")
	public ResponseEntity<?> removeJobPosting(@PathVariable Long jobId) {
		try {
			System.out.println("In update job posting");
			String msg = jobPostingService.removeJobPosting(jobId);
			return ResponseEntity.ok(new ApiResponse(msg));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
}
