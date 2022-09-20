package co.uk.skills.entity;

import co.uk.skills.constants.AreaOfInterest;
import co.uk.skills.constants.ProficiencyLevels;
import co.uk.skills.converters.AreaOfInterestConverter;
import co.uk.skills.converters.ProficiencyLevelConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "skills",schema = "skills-mngt")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@DynamicUpdate
public class Skill extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "area")
    @Convert(converter = AreaOfInterestConverter.class)
    private AreaOfInterest areaOfInterest;
    @Column(name = "proficiency_level")
    @Convert(converter = ProficiencyLevelConverter.class)
    private ProficiencyLevels proficiencyLevels;


}
