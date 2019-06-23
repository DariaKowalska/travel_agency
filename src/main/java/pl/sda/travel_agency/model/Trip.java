package pl.sda.travel_agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Trip {
 /*   skąd (Miasto, Lotnisko)
    dokąd (Miasto, Hotel, Lotnisko)
    data wyjazdu
    data powrotu
    ilość dni
    typ: (BB, HB, FB, AI - http://zw.lt/rozmaitosci/wyzywienie-w-hotelach-co-oznaczaja-bb-hb-fb-ai-ov-zpr/)
    cena za dorosłego
    cena za dziecko
            promowana
    ilość miejsc dorosłych
    ilość miejsc dla dzieci*/


 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id_trip;
 private String from;
 private String where;
 private LocalDate departureTime;
 private LocalDate arrivalTime;
 private FeedingEnum feedingType;
 private double pricePerAdult;
 private double pricePerChild;
 private double promotionalPrice;
 private int placeForAdult;
 private int placeForChildren;
 private boolean promotion;

 @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
 @JoinColumn(name = "id_airport")

 private Airport airport;

 @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
 @JoinColumn(name = "id_destination")

 private Destination destination;


 //TODO
 //konstruktor
 //toString
}
