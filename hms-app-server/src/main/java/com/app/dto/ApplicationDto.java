package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.ApplicationStatus;
import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationDto {
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@Email
	@NotBlank(message = "Email cannot be blank")
	private String email;
	@NotNull(message = "Post Applying for cannot be blank")
	private Category post;
	@JsonProperty(access = Access.READ_ONLY)
	private ApplicationStatus status;
}
