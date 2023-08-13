package com.hyomee.core.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
  private String error ;
  private String status;
  private String message;
  private String timestamp ;
  private String path ;
  private String code ;
  private T data ;


}
