package com.hyomee.core.config.message;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUTIL {

  @Resource
  private MessageSource source;

  static MessageSource messageSource;

  @PostConstruct
  public void initialize() {
    messageSource = source;
  }

  public static String getMessage(String messageCd) {
    return messageSource.getMessage(messageCd, null, LocaleContextHolder.getLocale());
  }

  public static String getMessage(String messageCd, Object[] messageArgs) {
    return messageSource.getMessage(messageCd, messageArgs, LocaleContextHolder.getLocale());
  }
}
