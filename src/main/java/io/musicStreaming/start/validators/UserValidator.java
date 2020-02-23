package io.musicStreaming.start.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import io.musicStreaming.start.validators.ivalid.IMatch;

public class UserValidator implements ConstraintValidator<IMatch, Object> {

	private String first;
	private String second;
	private String message;

    @Override
    public void initialize(final IMatch constraintAnnotation) {
    	message = "Both Passwords must match";
    	first = constraintAnnotation.first();
    	second = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value, ConstraintValidatorContext context) {
		boolean valid = true;

		try {
			Object firstObj = BeanUtils.getProperty(value, first);
			Object secondObj = BeanUtils.getProperty(value, second);
			 valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		}catch(Exception error) {}
		
        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(first)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
		return valid;
	}



	
}