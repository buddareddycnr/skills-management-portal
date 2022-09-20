package co.uk.skills.validation;

import org.springframework.beans.factory.annotation.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean isValidEmailFormat(String emailId,String emailPattern){
        Pattern compile = Pattern.compile(emailPattern);
        Matcher matcher = compile.matcher(emailId);
        if(matcher.matches())
            return true;
        else
            return false;
    }

}
