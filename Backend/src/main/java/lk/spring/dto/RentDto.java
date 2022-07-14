package lk.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.spring.entity.Customer;
import lk.spring.entity.RentDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class RentDto {
    private String rentId;
    private String status;
    private String regNum;
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Customer customer;
    private List<RentDetail> rentDetails;
}
