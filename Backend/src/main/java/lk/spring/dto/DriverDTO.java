package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverMobile;
    private String status;
    private String driverEmail;
    private String driverPassword;
}
