package io.musicStreaming.start.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.musicStreaming.start.validation.valid.PasswordMatches;
import io.musicStreaming.start.model.dto.UserDataTransferObject;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { 
	     
	    @Override
	    public void initialize(PasswordMatches constraintAnnotation) {}
	    
	    @Override
	    public boolean isValid(Object obj, ConstraintValidatorContext context){   
	    	UserDataTransferObject user = (UserDataTransferObject) obj;
	        return user.getPassword().equals(user.getMatchingPassword());    
	    }     
}
