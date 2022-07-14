package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.VehicleTypeDTO;
import lk.spring.entity.Customer;
import lk.spring.entity.VehicleType;
import lk.spring.repo.CustomerRepo;
import lk.spring.repo.VehicleTypeRepo;
import lk.spring.service.VehicleTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeService {
    @Autowired
    private VehicleTypeRepo vehicleTypeRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        if (!vehicleTypeRepo.existsById(vehicleTypeDTO.getId())) {
            vehicleTypeRepo.save(modelMapper.map(vehicleTypeDTO, VehicleType.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteVehicleType(String id) {
        if (vehicleTypeRepo.existsById(id)) {
            vehicleTypeRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }
    }

    @Override
    public void updateVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        if (vehicleTypeRepo.existsById(vehicleTypeDTO.getId())){
            vehicleTypeRepo.save(modelMapper.map(vehicleTypeDTO,VehicleType.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }
    }

    @Override
    public VehicleTypeDTO searchVehicleType(String id) {
        if (vehicleTypeRepo.existsById(id)) {

            return modelMapper.map(vehicleTypeRepo.findById(id).get(), VehicleTypeDTO.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<VehicleTypeDTO> getAllVehicleType() {
        return modelMapper.map(vehicleTypeRepo.findAll(),new TypeToken<List<VehicleTypeDTO>>(){}.getType());
    }


}
