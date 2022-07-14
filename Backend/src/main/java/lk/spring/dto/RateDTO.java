package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RateDTO {
    private String rateId;
    private double pricePreExKm;
    private double dailyRate;
    private double monthlyRate;
    private String freeKmForDay;
    private String freeKmForMonth;
}
