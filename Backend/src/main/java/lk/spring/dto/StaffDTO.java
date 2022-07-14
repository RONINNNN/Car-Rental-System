package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StaffDTO {
    private String staffId;
    private String name;
    private String address;
    private String mobile;
    private String type;
    private String email;
    private String password;

}
