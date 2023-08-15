package com.hyomee.core.customException.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Slf4j
public class BizExceptionUtils {


  public static void fillInStackTrace(boolean fillInStackTrace, String exception, String errorStr) {

    if (fillInStackTrace) {
      log.error("###### User Error Start #######" );
      log.error(String.format("==== Exception :: %s , ErrorMag :: %s", exception, errorStr));
      log.error("###### User Error End #######");
    }
  }

}
