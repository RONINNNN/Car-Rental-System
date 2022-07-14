package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.RentDto;
import lk.spring.entity.Customer;
import lk.spring.entity.Rent;
import lk.spring.repo.CustomerRepo;
import lk.spring.repo.RentRepo;
import lk.spring.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepo rentRepo;
    @Autowired

    private ModelMapper modelMapper;
    @Override
    public void saveRent(RentDto rentDto) {
        if (!rentRepo.existsById(rentDto.getRentId())) {
            rentRepo.save(modelMapper.map(rentDto, Rent.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteRent(String id) {
        if (rentRepo.existsById(id)) {
            rentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }
    }

    @Override
    public void updateRent(RentDto rentDto) {
        if (rentRepo.existsById(rentDto.getRentId())){
            rentRepo.save(modelMapper.map(rentDto,Rent.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }
    }

    @Override
    public RentDto searchRent(String id) {
        if (rentRepo.existsById(id)) {

            return modelMapper.map(rentRepo.findById(id).get(), RentDto.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<RentDto> getAllRent() {
        return modelMapper.map(rentRepo.findAll(),new TypeToken<List<RentDto>>(){}.getType());
    }
}
