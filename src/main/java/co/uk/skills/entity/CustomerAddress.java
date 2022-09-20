package co.uk.skills.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "customer_address",schema = "skills-mngt")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@DynamicUpdate
public class CustomerAddress extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
