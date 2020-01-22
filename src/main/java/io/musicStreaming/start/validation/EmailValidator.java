package org.baeldung.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private Pattern pattern;
    private Matcher matcher;

    private final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void initlize(final ValidEmail annotation){}

    @Override
    public boolean isValid(final String userName, final ConstraintValidatorContext context){return (ValidEmail(userName));}

    private boolean validEmail(final String email){
        pattern = Pattern.compile(emailPattern);
        matcher = Pattern.matcher(email);
        return matcher.matches();
    }
}