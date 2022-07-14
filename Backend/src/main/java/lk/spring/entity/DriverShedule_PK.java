package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DriverShedule_PK implements Serializable {
    private String staffId;
    private String regNumber;
    private String rentId;
}
