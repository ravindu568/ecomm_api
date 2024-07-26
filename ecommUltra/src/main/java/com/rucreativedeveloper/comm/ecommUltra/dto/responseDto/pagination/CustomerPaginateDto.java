package com.rucreativedeveloper.comm.ecommUltra.dto.responseDto.pagination;

import com.rucreativedeveloper.comm.ecommUltra.dto.responseDto.ResponseCustomerDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class CustomerPaginateDto {

    private long count;
    private List<ResponseCustomerDto> dataList;

}
