package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Vehicle{
    @Id
    private String regNumber;
    private String colour;
    private String transmission;
    private String brand;
    private String status;
    private String fuelType;
    private double runningKm;
    private String numOfPassenger;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "rateId", referencedColumnName = "rateId", nullable = false)
    private Rates rates;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "vehicleTypeId",referencedColumnName = "Id",nullable = false)
    private VehicleType vehicleType;

}
