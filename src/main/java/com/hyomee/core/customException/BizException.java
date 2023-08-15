package com.hyomee.core.customException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BizException extends RuntimeException{



  private String code;
  private String[] args;


  public BizException() {
    super();
  }

  /**
   * 사용자 메세지를 화면으로 바로 노출
   * @param message
   */
  public BizException(String message) {
    super(message);
    this.code = message;
  }

  public BizException(String code, String... args) {
    this.code = code;
    this.args = args;

  }
}
