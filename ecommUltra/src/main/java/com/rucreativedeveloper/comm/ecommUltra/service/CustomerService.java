package com.rucreativedeveloper.comm.ecommUltra.service;

import com.rucreativedeveloper.comm.ecommUltra.dto.requestDto.RequestCustomerDto;
import com.rucreativedeveloper.comm.ecommUltra.dto.responseDto.ResponseCustomerDto;
import com.rucreativedeveloper.comm.ecommUltra.dto.responseDto.pagination.CustomerPaginateDto;


public interface CustomerService {

    public void create(RequestCustomerDto dto);
    public ResponseCustomerDto getById(String id);
    public void update(String id, RequestCustomerDto dto);
    public CustomerPaginateDto findAll(String searchText,int page,int size);
    public void delete(String id);
}
