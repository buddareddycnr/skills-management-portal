package co.uk.skills.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@ToString
@Table(name = "login",schema = "skills-mngt")
@Setter
@Getter
public class Login extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "user_password")
    private String password;
    @Column(name = "retry_count")
    private int retryCount;
    @Column(name = "password_expiry_date")
    private Timestamp passwordExpiryDate;
}
