package co.uk.skills.converters;

import co.uk.skills.constants.Titles;
import co.uk.skills.exception.UnsupportedTitleException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class TitleConverter implements AttributeConverter<Titles, String> {
    /**
     * @param title
     * @return
     */
    @Override
    public String convertToDatabaseColumn(Titles title) {
        Titles dbColumnTitle = Arrays.stream(Titles.values()).filter(titles -> title.equals(titles)).findFirst().orElseThrow(() -> new UnsupportedTitleException("Please verify the title which you passed, Allowed titles are MR,MRS,DR,CAPTAIN"));
        return dbColumnTitle.toString();
    }

    /**
     * @param title
     * @return
     */
    @Override
    public Titles convertToEntityAttribute(String title) {
        return Arrays.stream(Titles.values()).filter(titles ->
                title.equals(titles.toString())).findFirst().orElseThrow(() ->
                new UnsupportedTitleException("Please verify the title which you passed, Allowed titles are MR,MRS,DR,CAPTAIN"));
    }
}
