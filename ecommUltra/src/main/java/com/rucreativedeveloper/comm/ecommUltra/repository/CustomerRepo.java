package com.rucreativedeveloper.comm.ecommUltra.repository;

import com.rucreativedeveloper.comm.ecommUltra.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
