package lk.spring.service;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.VehicleTypeDTO;

import java.util.List;

public interface VehicleTypeService {
    void saveVehicleType (VehicleTypeDTO vehicleTypeDTO);
    void deleteVehicleType(String id);
    void updateVehicleType(VehicleTypeDTO vehicleTypeDTO);
    VehicleTypeDTO searchVehicleType(String id);
    List<VehicleTypeDTO> getAllVehicleType();
}
