package io.musicStreaming.start.validators.ivalid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;

import io.musicStreaming.start.validators.UserValidator;
 
 
 
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidator.class)
@Documented
public @interface IMatch {
 
    String message() default "Both Passwords must match";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    String first();
    String second();
    
}