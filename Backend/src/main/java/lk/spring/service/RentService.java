package lk.spring.service;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.RentDto;

import java.util.List;

public interface RentService {
    void saveRent (RentDto rentDto);
    void deleteRent(String id);
    void updateRent(RentDto rentDto);
    RentDto searchRent(String id);
    List<RentDto> getAllRent();
}
