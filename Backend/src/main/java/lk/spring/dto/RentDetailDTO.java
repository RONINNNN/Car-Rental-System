package lk.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.spring.entity.Rent;
import lk.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDetailDTO {
    private String rentId;
    private String regNumber;
    private String staffId;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    private double km;
    private double damageCost;
    private double rentCost;
    private Vehicle vehicle;
    private Rent rent;
}
