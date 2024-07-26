package com.rucreativedeveloper.comm.ecommUltra.service.impl;

import com.rucreativedeveloper.comm.ecommUltra.dto.requestDto.RequestCustomerDto;
import com.rucreativedeveloper.comm.ecommUltra.dto.responseDto.ResponseCustomerDto;
import com.rucreativedeveloper.comm.ecommUltra.dto.responseDto.pagination.CustomerPaginateDto;
import com.rucreativedeveloper.comm.ecommUltra.entity.Customer;
import com.rucreativedeveloper.comm.ecommUltra.exeption.EntryNotFoundException;
import com.rucreativedeveloper.comm.ecommUltra.repository.CustomerRepo;
import com.rucreativedeveloper.comm.ecommUltra.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

private final CustomerRepo customerRepo;

    @Override
    public void create(RequestCustomerDto dto){
        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .isActive(dto.isActive())
        .build();
    customerRepo.save(customer);
    }

    @Override
    public ResponseCustomerDto getById(String id) {
        Optional<Customer> selectedCustomer =customerRepo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new EntryNotFoundException("Customer not found");

        }else{
            return toResponseCustomerDto(selectedCustomer.get());
        }
    }

    @Override
    public void update(String id, RequestCustomerDto dto) {
        Optional<Customer> selectedCustomer =customerRepo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new EntryNotFoundException("Customer not found");

        }

        Customer customer = selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setActive(dto.isActive());

        customerRepo.save(customer);

    }

    @Override
    public CustomerPaginateDto findAll(String searchText, int page, int size) {
        return CustomerPaginateDto.builder()
                .dataList(customerRepo.findAllWithSearchText(searchText, PageRequest.of(page,size))
                        .stream().map(this::toResponseCustomerDto).toList())
                .count(customerRepo.countAllWithSearchText(searchText))
        .build();
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    private ResponseCustomerDto toResponseCustomerDto(Customer customer){
        return ResponseCustomerDto.builder()
                .propertyId(customer.getPropertyId())
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .isActive(customer.isActive())
                .build();
    }


}
