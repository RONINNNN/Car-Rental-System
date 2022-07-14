package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Rates {
    @Id
    private String rateId;
    private double pricePreExKm;
    private double dailyRate;
    private double monthlyRate;
    private String freeKmForDay;
    private String freeKmForMonth;


}
