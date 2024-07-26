package com.rucreativedeveloper.comm.ecommUltra.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StanderedResponse {

    private int code;
    private String message;
    private Object data;
}
