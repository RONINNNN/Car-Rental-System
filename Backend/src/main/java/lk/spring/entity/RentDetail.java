package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@IdClass(RentDetail_PK.class)
public class RentDetail {
    @Id
    private String rentId;
    @Id
    private String regNumber;
    private String staffId;
    private String status;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double km;
    private double damageCost;
    private double rentCost;

    @ManyToOne
    @JoinColumn(name = "regNumber", referencedColumnName = "regNumber", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", insertable = false, updatable = false)
    private Rent rent;
}
