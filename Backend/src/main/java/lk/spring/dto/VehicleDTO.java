package lk.spring.dto;

import lk.spring.entity.Rates;
import lk.spring.entity.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private String regNumber;
    private String colour;
    private String transmission;
    private String brand;
    private String status;
    private String fuelType;
    private double runningKm;
    private String numOfPassenger;
    private Rates rates;
    private VehicleType vehicleType;
}
