package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.DriverDTO;
import lk.spring.dto.VehicleDTO;
import lk.spring.entity.Customer;
import lk.spring.entity.Driver;
import lk.spring.repo.CustomerRepo;
import lk.spring.repo.DriverRepo;
import lk.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getDriverId())) {
            driverRepo.save(modelMapper.map(driverDTO, Driver.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)) {
            driverRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriverId())){
            driverRepo.save(modelMapper.map(driverDTO,Driver.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }

    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (driverRepo.existsById(id)) {
            return modelMapper.map(driverRepo.findById(id).get(),DriverDTO.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return modelMapper.map(driverRepo.findAll(),new TypeToken<List<DriverDTO>>(){}.getType());
    }
}
