package co.uk.skills.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization",schema = "skills-mngt")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@DynamicUpdate
public class Organization extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "registration_number")
    private String registrationNumber;
    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = OrganizationAddress.class)
    @JoinColumn(name = "organization_id",referencedColumnName = "id")
    private List<OrganizationAddress> organizationAddress;
}
