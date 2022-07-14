package lk.spring.service;

import lk.spring.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff (StaffDTO staffDTO);
    void deleteStaff(String id);
    void updateStaff(StaffDTO staffDTO);
    StaffDTO searchStaff(String id);
    List<StaffDTO> getAllStaff();
}
