package io.musicStreaming.start.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import io.musicStreaming.start.model.dto.UserDataTransferObject;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserDataTransferObject.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		notEmptyValidation(errors);

		UserDataTransferObject user = castToUserDTO(target);
	}

	private UserDataTransferObject castToUserDTO(Object target){
		return (UserDataTransferObject) target; 
	}

	private void notEmptyValidation(Errors errors){
		ValidationUtils.rejectIfEmpty(errors, "firstName", "user.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "username", "user.username.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "matchingPassword", "user.matchingPassword.empty");

	}


}