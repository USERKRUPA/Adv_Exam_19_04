package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobPostingDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank(message="job title must not be blank")
	private String jobTitle;
	
	@NotBlank(message="company name must not be blank")
	private String companyName;
	
	@NotBlank(message="location must not be blank")
	private String location;
	
	@NotBlank(message="description must not be blank")
	private String description;
	
	@NotBlank(message="requirements must not be blank")
	private String requirements;
	
	private double salary;
	
	private LocalDate postingDate;
}
