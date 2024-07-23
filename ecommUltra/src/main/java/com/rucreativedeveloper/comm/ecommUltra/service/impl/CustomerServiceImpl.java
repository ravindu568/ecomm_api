package com.rucreativedeveloper.comm.ecommUltra.service.impl;

import com.rucreativedeveloper.comm.ecommUltra.dto.requestDto.RequestCustomerDto;
import com.rucreativedeveloper.comm.ecommUltra.entity.Customer;
import com.rucreativedeveloper.comm.ecommUltra.repository.CustomerRepo;
import com.rucreativedeveloper.comm.ecommUltra.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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




}
