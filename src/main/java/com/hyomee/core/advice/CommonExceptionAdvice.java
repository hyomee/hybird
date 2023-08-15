package com.hyomee.core.advice;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import com.hyomee.core.common.dto.ResponseDTO;
import com.hyomee.core.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.Timestamp;

@Slf4j
@RestControllerAdvice
public class CommonExceptionAdvice {

//
//  @ExceptionHandler(RecordNotFoundException.class)
//  public ResponseEntity<Error> handleRecordNotFoundException(RecordNotFoundException exception) {
//    log.info(exception.getMessage());
//    return ResponseEntity.noContent().build();
//  }

  @ExceptionHandler(ElasticsearchException.class)
  public ResponseEntity<ResponseDTO> handleRecordNotFoundException(ElasticsearchException exception) {
    log.info(exception.getMessage()); ResponseDTO responseDTO = ResponseDTO.builder()
            .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .message(exception.getMessage())
            .error("IOException")
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .path(RequestUtils.getHttpServletRequest().getRequestURL().toString())
            .timestamp(String.valueOf(new Timestamp(System.currentTimeMillis())))
            .data("Error :: No Data")
            .build();

    return ResponseEntity.status( responseDTO.getStatus()).body(responseDTO);
  }


  @ExceptionHandler(IOException.class)
  public ResponseEntity<ResponseDTO> handleIOException(IOException exception) {
    log.error(exception.getMessage());
    ResponseDTO responseDTO = ResponseDTO.builder()
            .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .message(exception.getMessage())
            .error("IOException")
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .path(RequestUtils.getHttpServletRequest().getRequestURL().toString())
            .timestamp(String.valueOf(new Timestamp(System.currentTimeMillis())))
            .data("Error :: No Data")
            .build();

    return ResponseEntity.status( responseDTO.getStatus()).body(responseDTO);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseDTO> handleException(Exception exception) {
    log.error(exception.getMessage());
    ResponseDTO responseDTO = ResponseDTO.builder()
            .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .message(exception.getMessage())
            .error("Exception")
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .path(RequestUtils.getHttpServletRequest().getRequestURL().toString())
            .timestamp(String.valueOf(new Timestamp(System.currentTimeMillis())))
            .data("Error :: No Data")
            .build();
    return ResponseEntity.status(responseDTO.getStatus()).body(responseDTO);
  }
}
