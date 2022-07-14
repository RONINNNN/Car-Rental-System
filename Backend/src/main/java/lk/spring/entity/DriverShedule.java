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
@IdClass(DriverShedule_PK.class)
public class DriverShedule {
    @Id

    private String staffId;
    @Id
    private String regNumber;
    @Id
    private String rentId;
    private LocalDate rent_Date;
    private LocalDate return_Date;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "staffId", insertable = false, updatable = false)
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "regNumber", referencedColumnName = "regNumber", insertable = false, updatable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", insertable = false, updatable = false)
    private Rent rent;
}
