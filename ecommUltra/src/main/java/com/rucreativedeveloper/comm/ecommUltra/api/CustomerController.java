package com.rucreativedeveloper.comm.ecommUltra.api;


import com.rucreativedeveloper.comm.ecommUltra.dto.requestDto.RequestCustomerDto;
import com.rucreativedeveloper.comm.ecommUltra.service.CustomerService;
import com.rucreativedeveloper.comm.ecommUltra.util.StanderedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<StanderedResponse> create(@RequestBody RequestCustomerDto dto){
        customerService.create(dto);

        return new ResponseEntity<>(
         new StanderedResponse(201,"Customer Sucessfully Saved",null), HttpStatus.CREATED
        );


    }
    @GetMapping("/{id}")
    public ResponseEntity<StanderedResponse> getById(@PathVariable String id){

        return new ResponseEntity<>(
                new StanderedResponse(200,"Customer data",customerService.getById(id)), HttpStatus.OK
        );
    }

    @GetMapping("/list")

    public ResponseEntity<StanderedResponse> findAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return new ResponseEntity<>(
                new StanderedResponse(200,"Customer list!..",
                        customerService.findAll(searchText, page, pageSize)),
                HttpStatus.OK
        );
    }


    @PutMapping("/{Id}")
    public ResponseEntity<StanderedResponse> update(@PathVariable String Id,
                         @RequestBody RequestCustomerDto dto){

        customerService.update(Id,dto);

        return new ResponseEntity<>(
                new StanderedResponse(201,"Customer has updated!",null), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<StanderedResponse> delete(@PathVariable String Id){
        customerService.delete(Id);
        return new ResponseEntity<>(
                new StanderedResponse(204,"Customer was deleted!..",null),
                HttpStatus.NO_CONTENT
        );
    }

    //localhost:3307/api/v1/customers/

}
