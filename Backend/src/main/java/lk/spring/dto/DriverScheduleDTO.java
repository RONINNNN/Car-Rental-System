package lk.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.spring.entity.Admin;
import lk.spring.entity.Rent;
import lk.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverScheduleDTO {
    private String staffId;
    private String regNumber;
    private String rentId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rent_Date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate return_Date;
    private Admin admin;
    private Vehicle vehicle;
    private Rent rent;
}
