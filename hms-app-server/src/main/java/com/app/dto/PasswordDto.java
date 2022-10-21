package com.app.dto;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordDto {

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%#*?&])[A-Za-z\\d@$!%*?&]{8,15}$", 
			message = "Password must be atleast 8 ch and max 15 ch and must contain 1 upper case, 1 lower case letter,1 special character")

	private String password;
	
}
