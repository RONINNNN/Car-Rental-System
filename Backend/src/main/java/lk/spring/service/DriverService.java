package lk.spring.service;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.DriverDTO;
import lk.spring.dto.VehicleDTO;

import java.util.List;

public interface DriverService {
    void saveDriver (DriverDTO driverDTO);
    void deleteDriver(String id);
    void updateDriver(DriverDTO driverDTO);
    DriverDTO searchDriver(String id);
    List<DriverDTO> getAllDriver();
}
