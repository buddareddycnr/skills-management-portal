package co.uk.skills.converters;

import co.uk.skills.constants.AreaOfInterest;
import co.uk.skills.constants.Titles;
import co.uk.skills.exception.UnsupportedAreaOfInterestException;
import co.uk.skills.exception.UnsupportedTitleException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class AreaOfInterestConverter implements AttributeConverter<AreaOfInterest,String> {
    /**
     * @param areaOfInterest
     * @return
     */
    @Override
    public String convertToDatabaseColumn(AreaOfInterest areaOfInterest) {
        AreaOfInterest dbColumnAreaOfInterest = Arrays.stream(AreaOfInterest.values()).filter(areaOfInterests ->
                areaOfInterest.equals(areaOfInterests)).findFirst().orElseThrow(() ->
                new UnsupportedAreaOfInterestException("Please verify the area of interest which you passed, Allowed values are Programming,Development,Scripting,Testing,Devops,Other"));
        return dbColumnAreaOfInterest.toString();
    }

    /**
     * @param areaOfInterest
     * @return
     */
    @Override
    public AreaOfInterest convertToEntityAttribute(String areaOfInterest) {
        return Arrays.stream(AreaOfInterest.values()).filter(areaOfInterests ->
                areaOfInterest.equals(areaOfInterests.toString())).findFirst().orElseThrow(() ->
                new UnsupportedAreaOfInterestException("Please verify the area of interest which you passed, Allowed values are  Programming,Development,Scripting,Testing,Devops,Other"));

    }
}
