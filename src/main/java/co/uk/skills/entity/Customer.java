package co.uk.skills.entity;

import co.uk.skills.constants.AccountStatus;
import co.uk.skills.constants.Gender;
import co.uk.skills.constants.Titles;
import co.uk.skills.converters.GenderConverter;
import co.uk.skills.converters.TitleConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name ="customer",schema = "skills-mngt")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@DynamicUpdate
public class Customer extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    @Convert(converter = TitleConverter.class)
    private Titles title;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "home_phone_number")
    private String homePhoneNumber;
    @Column(name = "account_status")
    private AccountStatus accountStatus = AccountStatus.CREATED;
    @Column(name = "organization_id")
    private long organizationId;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = CustomerAddress.class)
    @JoinColumn(name = "customer_fk",referencedColumnName = "id")
    private List<CustomerAddress> customerAddress;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Skill.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private List<Skill> skills;
}
