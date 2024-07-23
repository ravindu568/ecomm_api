package com.rucreativedeveloper.comm.ecommUltra.api;


import com.rucreativedeveloper.comm.ecommUltra.dto.requestDto.RequestCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @PostMapping
    public String create(@RequestBody RequestCustomerDto dto){return dto.getAddress();}
    @GetMapping("/list")
    public String findAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int pageSize
    ){return "findAll()";}
    @GetMapping("/{id}")
    public String getById(
            @PathVariable String id
    ){return "getById()";}
    @PutMapping
    public String update(){return "update()";}
    @DeleteMapping
    public String delete(){return "delete()";}

    //localhost:3307/api/v1/customers/

}
