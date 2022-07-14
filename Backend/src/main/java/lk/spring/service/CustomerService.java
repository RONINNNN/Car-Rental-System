package lk.spring.service;

import lk.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer (CustomerDTO customerDTO);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO customerDTO);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomer();
}
