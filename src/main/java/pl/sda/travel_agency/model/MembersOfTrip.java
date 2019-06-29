package pl.sda.travel_agency.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MembersOfTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_member;

    private String name;
    private String lastname;
    private LocalDate birthDay;
    private Long pesel;
    private String adress;
    private Long telephoneNumber;
    private String email;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    private SoldTrip soldTrip;





}
