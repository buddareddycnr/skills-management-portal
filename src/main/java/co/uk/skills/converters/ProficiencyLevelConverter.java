package co.uk.skills.converters;

import co.uk.skills.constants.ProficiencyLevels;
import co.uk.skills.exception.UnsupportedProficiencyLevelException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class ProficiencyLevelConverter implements AttributeConverter<ProficiencyLevels,String> {
    /**
     * @param proficiencyLevels
     * @return
     */
    @Override
    public String convertToDatabaseColumn(ProficiencyLevels proficiencyLevels) {
        var dbColumnTitle = Arrays.stream(ProficiencyLevels.values()).filter(proficiencyLevel ->
                proficiencyLevels.equals(proficiencyLevel)).findFirst().orElseThrow(() ->
                new UnsupportedProficiencyLevelException("Please verify the proficiency level which you passed, Allowed values are Expert,Practitioner,Working,Awareness"));
        return dbColumnTitle.toString();
    }

    /**
     * @param proficiencyLevel
     * @return
     */
    @Override
    public ProficiencyLevels convertToEntityAttribute(String proficiencyLevel) {
        return Arrays.stream(ProficiencyLevels.values()).filter(proficiencyLevels ->
                proficiencyLevel.equals(proficiencyLevels.toString())).findFirst().orElseThrow(() ->
                new UnsupportedProficiencyLevelException("Please verify the proficiency level which you passed,  Allowed values are Expert,Practitioner,Working,Awareness"));

    }
}
