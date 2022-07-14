package lk.spring.service;


import lk.spring.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle (VehicleDTO vehicleDTO );
    void deleteVehicle(String id);
    void updateStaff(VehicleDTO vehicleDTO);
    VehicleDTO searchVehicle(String id);
    List<VehicleDTO> getAllVehicle();
}
