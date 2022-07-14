package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.StaffDTO;
import lk.spring.entity.Admin;
import lk.spring.entity.Customer;
import lk.spring.repo.StaffRepo;
import lk.spring.service.StaffService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        if (!staffRepo.existsById(staffDTO.getStaffId())) {
            staffRepo.save(modelMapper.map(staffDTO, Admin.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteStaff(String id) {
        if (staffRepo.existsById(id)) {
            staffRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }
    }

    @Override
    public void updateStaff(StaffDTO staffDTO) {
        if (staffRepo.existsById(staffDTO.getStaffId())){
            staffRepo.save(modelMapper.map(staffDTO,Admin.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }
    }

    @Override
    public StaffDTO searchStaff(String id) {
        if (staffRepo.existsById(id)) {

            return modelMapper.map(staffRepo.findById(id).get(), StaffDTO.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return modelMapper.map(staffRepo.findAll(),new TypeToken<List<StaffDTO>>(){}.getType());
    }
}
