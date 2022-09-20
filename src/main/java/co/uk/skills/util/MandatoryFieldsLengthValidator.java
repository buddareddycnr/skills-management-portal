package co.uk.skills.util;

import co.uk.skills.entity.*;
import co.uk.skills.validation.FieldsValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class MandatoryFieldsLengthValidator<T> {
    public boolean isValidInput(T inputObject) {
        if (inputObject instanceof Organization) {
            var organization = (Organization) inputObject;
            if (isValidStringLength(organization.getCity()) && isValidStringLength(organization.getName())
                    && isValidStringLength(organization.getEmailId()))
                return true;
            else
                return false;
        } else if (inputObject instanceof Customer) {
            var customer = (Customer) inputObject;
            if (isValidStringLength(customer.getFirstName()) && isValidStringLength(customer.getLastName())
                    && isValidStringLength(customer.getEmailId()) && isValidStringLength(customer.getMobileNumber()))
                return true;
            else
                return false;
        } else if (inputObject instanceof Skill) {
            var skill = (Skill) inputObject;
            if (isValidStringLength(skill.getName()) && isValidStringLength(skill.getProficiencyLevels().toString())
                    && isValidStringLength(skill.getAreaOfInterest().toString()))
                return true;
            else
                return false;
        } else if (inputObject instanceof CustomerAddress) {
            var customerAddress = (CustomerAddress) inputObject;
            if (isValidStringLength(customerAddress.getCity()) && isValidStringLength(customerAddress.getFlatNumberAndName())
                    && isValidStringLength(customerAddress.getPostcode()))
                return true;
            else
                return false;
        } else if (inputObject instanceof OrganizationAddress) {
            var orgAddress = (OrganizationAddress) inputObject;
            if (isValidStringLength(orgAddress.getCity()) && isValidStringLength(orgAddress.getFlatNumberAndName()))
                return true;
            else
                return false;
        } else if (inputObject instanceof Login) {
            var login = (Login) inputObject;
            if (isValidStringLength(login.getUsername()) && isValidStringLength(login.getPassword()))
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean isValidStringLength(String input) {
        FieldsValidator<String> stringFieldsValidator = (data) -> {
            if (StringUtils.isNotBlank(data))
                return true;
            else
                return false;
        };
        return stringFieldsValidator.isValidLength(input);
    }

    public boolean isValidLong(long input) {
        FieldsValidator<Long> integerFieldsValidator = (data) -> {
            if (input != 0)
                return true;
            else
                return false;
        };
        return integerFieldsValidator.isValidLength(input);
    }
}
