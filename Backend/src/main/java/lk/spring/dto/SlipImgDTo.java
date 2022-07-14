package lk.spring.dto;

import lk.spring.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SlipImgDTo {
    private String imgId;
    private String description;
    private Rent rent;
}
