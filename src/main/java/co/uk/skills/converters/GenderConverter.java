package co.uk.skills.converters;

import co.uk.skills.constants.Gender;
import co.uk.skills.exception.UnsupportedGenderException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender,String> {
    /**
     * @param gender
     * @return
     */
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        var dbColumnTitle = Arrays.stream(Gender.values()).filter(gen ->
                gen.equals(gender)).findFirst().orElseThrow(() ->
                new UnsupportedGenderException("Please verify the gender which you passed, Allowed values are Male,Female,Transgender"));
        return dbColumnTitle.toString();
    }

    /**
     * @param gender
     * @return
     */
    @Override
    public Gender convertToEntityAttribute(String gender) {
        return Arrays.stream(Gender.values()).filter(gen ->
                gen.equals(gen.toString())).findFirst().orElseThrow(() ->
                new UnsupportedGenderException("Please verify the gender which you passed, Allowed values are Male,Female,Transgender"));

    }
}
