//package pl.sda.travel_agency.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//@Setter
//@Getter
//@ToString
//@Entity
//@Table(name = "orders")
//public class Order implements Serializable {
//
//    @OneToOne
//    private Trip trip;
//
//    private Integer quantity;
//
//    @Column(name = "price_adult")
//    private BigDecimal tripPriceAdult;
//
//    @Column(name = "price_child")
//    private BigDecimal tripPriceChild;
//
//    @Column(name = "price_promotion")
//    private BigDecimal tripPricePromotion;
//}
