package lk.spring.service;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.RateDTO;

import java.util.List;

public interface RateService {
    void saveRate (RateDTO rateDTO);
    void deleteRate(String id);
    void updateRate(RateDTO rateDTO);
    RateDTO searchRate(String id);
    List<RateDTO> getAllRate();
}
