package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Rent {
    @Id
    private String rentId;
    private String status;
    private String regNum;
    private String reason;
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "cusID", referencedColumnName = "cusId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<RentDetail> rentDetails;
}
