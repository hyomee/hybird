package com.hyomee.core.advice;

import com.hyomee.core.common.dto.ResponseDTO;
import com.hyomee.core.config.message.MessageUTIL;
import com.hyomee.core.customException.BizException;
import com.hyomee.core.customException.utils.BizExceptionUtils;
import com.hyomee.core.utils.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.text.MessageFormat;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class BizExceptionAdvice {

  @Value("${user.error.fillInStackTrace:false}")
  private boolean fillInStackTrace;

  @Value("${user.error.printStackTrace:false}")
  private boolean printStackTrace;

  private final MessageSource messageSource;

  @ExceptionHandler(BizException.class)
  public ResponseEntity<ResponseDTO> bizException(BizException ex,
                                                  WebRequest request) {

    if (printStackTrace) {
      ex.printStackTrace();
    }

    if (fillInStackTrace) {
       BizExceptionUtils.fillInStackTrace(fillInStackTrace, "BizException", ex.fillInStackTrace().toString());
    }

    String errMessage = getErrorMsg(ex);

    ResponseDTO responseDTO = ResponseDTO.builder()
            .code(ex.getCode())
            .message(errMessage)
            .error("BizException")
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .path(RequestUtils.getHttpServletRequest().getRequestURL().toString())
            .timestamp(String.valueOf(new Timestamp(System.currentTimeMillis())))
            .data("Error :: No Data")
            .build();

    return ResponseEntity.status(responseDTO.getStatus()).body(responseDTO);

  }

  private static String getErrorMsg(BizException ex) {
    String errMsg ;
    try {

      if (ex.getArgs() != null && ex.getArgs().length > 0) {
        errMsg = MessageUTIL.getMessage(ex.getCode(), ex.getArgs());
      } else {
        errMsg = MessageUTIL.getMessage(ex.getCode());
      }
    } catch (NoSuchMessageException nex) {

      if (ex.getArgs() != null && ex.getArgs().length > 0) {
        errMsg = MessageFormat.format(ex.getCode(), ex.getArgs());
      } else {
        errMsg = ex.getCode();
      }

      ex.setCode("ERR_0000");
    }
    return errMsg;
  }
}
