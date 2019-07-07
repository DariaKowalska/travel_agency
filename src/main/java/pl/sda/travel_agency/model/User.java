package pl.sda.travel_agency.model;

import lombok.*;
import pl.sda.travel_agency.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String name;
    private String lastname;

    private String email;
    private String password;
    private RoleEnum roleEnum = RoleEnum.USER_ROLE;
    private boolean active = true;
    private Integer buyPerAdult;
    private Integer buyPerChild;


    @ManyToMany(mappedBy = "users")
    private Set<Trip> trips;

    public User(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}

