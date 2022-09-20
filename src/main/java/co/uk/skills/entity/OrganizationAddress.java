package co.uk.skills.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "organization_address",schema = "skills-mngt")
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class OrganizationAddress extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "address_line1")
    private String flatNumberAndName;
    @Column(name = "address_line2")
    private String streetName;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
}
