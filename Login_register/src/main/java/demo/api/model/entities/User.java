package demo.api.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import demo.api.constant.Constants;
import lombok.Data;

import javax.persistence.*;;import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User extends IdEntity{

    public User() {
        username = password = Constants.EMPTY;
        email =  Constants.EMPTY;

    }

    @JsonProperty(required = true)
    @Column(name = "username")
    private String username;

    @JsonProperty(required = true)
    @Column(name = "email")
    private String email;

    @JsonProperty(required = true)
    @Column(name = "password")
    private String password;

    /*@JsonProperty(required = true)
    @Column(name = "level")
    private Integer level;*/

    @JsonProperty(required = false)
    @Column(name = "last_time_used")
    private Date last_time_used;

    @JsonProperty(required = true)
    @Column(name = "created")
    private Long created_at;

    @JsonProperty(required = false)
    @Column(name = "modified")
    private Long updated_at;

    @JsonProperty(required = false)
    @Column(name = "last_ip")
    private String last_ip;


    public boolean isValid() {
        return username.isEmpty() || password.isEmpty();
    }

    public boolean isValidFull() {
        return username.isEmpty() || password.isEmpty() || email.isEmpty();
    }

}
