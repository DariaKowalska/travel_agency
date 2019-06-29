//package pl.sda.travel_agency.model;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class SoldTrip {
//
// /*   wycieczka
//    dane uczestników
//    kwota*/
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id_soldTrip;
//
//    private BigDecimal price_perChild;
//    private BigDecimal price_perAdult;
//
//    private LocalDate dateOfPurchase;
//
//
//    @OneToMany(cascade = {CascadeType.ALL},
//            fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_member")
//    private List<MembersOfTrip>membersOfTrips;
//
//
//}
