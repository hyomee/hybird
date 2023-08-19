package com.hyomee.demo.mock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MockDemoDTO {

    private String name;
    private AddressDTO address;
    private List<DataDTO> datas;

}
