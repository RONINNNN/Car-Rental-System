package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.entity.Customer;
import lk.spring.repo.CustomerRepo;
import lk.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCusId())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        } else {
            throw new RuntimeException("Already saved ");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("Failed! try again");
        }

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCusId())){
            customerRepo.save(modelMapper.map(customerDTO,Customer.class));
        }else {
            throw new RuntimeException("Update Failed.");
        }

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerRepo.existsById(id)) {

            return modelMapper.map(customerRepo.findById(id).get(), CustomerDTO.class);
        }else {
            throw new RuntimeException("Invalid Search.");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
