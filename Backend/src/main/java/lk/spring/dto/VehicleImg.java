package lk.spring.dto;

import lk.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleImg {
    private String imgId;
    private String description;
    private Vehicle vehicle;
}
