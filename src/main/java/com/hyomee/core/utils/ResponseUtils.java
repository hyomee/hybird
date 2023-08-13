package com.hyomee.core.utils;

import com.hyomee.core.common.ResponseDTO;
import com.hyomee.core.constant.CommonConstant;
import com.hyomee.core.constant.HttpStausConstant;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

public class ResponseUtils {

  public static ResponseEntity<Object> completed(Object obj) {



    ResponseDTO responseDTO = ResponseDTO.builder()
            .code(String.valueOf(HttpStausConstant.OK.value()))
            .message(CommonConstant.COMMON_EMPTY)
            .error(CommonConstant.COMMON_EMPTY)
            .status(String.valueOf(HttpStausConstant.OK.value()))
            .path(RequestUtils.getHttpServletRequest().getRequestURL().toString())
            .timestamp(String.valueOf(new Timestamp(System.currentTimeMillis())))
            .data(obj)
            .build();

    return ResponseEntity.status(HttpStausConstant.OK.value()).body(responseDTO);//

  }

}
