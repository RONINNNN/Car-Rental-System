package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.VehicleDTO;
import lk.spring.entity.Customer;
import lk.spring.entity.Vehicle;
import lk.spring.repo.VehicleRepo;
import lk.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getRegNumber())) {
            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }
    }

    @Override
    public void updateStaff(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getRegNumber())){
            vehicleRepo.save(modelMapper.map(vehicleDTO,Vehicle.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (vehicleRepo.existsById(id)) {

            return modelMapper.map(vehicleRepo.findById(id).get(), VehicleDTO.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return modelMapper.map(vehicleRepo.findAll(),new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
