package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.RateDTO;
import lk.spring.entity.Customer;
import lk.spring.entity.Rates;
import lk.spring.repo.CustomerRepo;
import lk.spring.repo.RateRepo;
import lk.spring.service.RateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepo rateRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveRate(RateDTO rateDTO) {
        if (!rateRepo.existsById(rateDTO.getRateId())) {
            rateRepo.save(modelMapper.map(rateDTO, Rates.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteRate(String id) {
        if (rateRepo.existsById(id)) {
            rateRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }
    }

    @Override
    public void updateRate(RateDTO rateDTO) {
        if (rateRepo.existsById(rateDTO.getRateId())){
            rateRepo.save(modelMapper.map(rateDTO,Rates.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }
    }

    @Override
    public RateDTO searchRate(String id) {
        if (rateRepo.existsById(id)) {

            return modelMapper.map(rateRepo.findById(id).get(), RateDTO.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<RateDTO> getAllRate() {
        return modelMapper.map(rateRepo.findAll(),new TypeToken<List<RateDTO>>(){}.getType());
    }
}
