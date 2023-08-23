package com.hyomee.core.utils;

import com.hyomee.core.common.dto.ResponseDTO;
import com.hyomee.core.common.constant.CommonConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

public class ResponseUtils {

  public static ResponseEntity<Object> completed(Object obj) {

//    ResponseDTO responseDTO = ResponseDTO.builder()
//            .code(String.valueOf(HttpStatus.OK.value()))
//            .message(CommonConstant.COMMON_EMPTY)
//            .error(CommonConstant.COMMON_EMPTY)
//            .status(HttpStatus.OK.value())
//            .path(RequestUtils.getHttpServletRequest().getRequestURL().toString())
//            .timestamp(String.valueOf(new Timestamp(System.currentTimeMillis())))
//            .data(obj)
//            .build();

    return ResponseEntity.status(HttpStatus.OK.value()).body(obj);//

  }

}
