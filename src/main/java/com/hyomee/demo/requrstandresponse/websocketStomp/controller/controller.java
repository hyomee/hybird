package com.hyomee.demo.requrstandresponse.websocketStomp.controller;

import com.hyomee.core.utils.UuidUtils;
import com.hyomee.demo.requrstandresponse.websocketStomp.message.GreetingMessag;
import com.hyomee.demo.requrstandresponse.websocketStomp.message.HelloMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
@RequiredArgsConstructor
public class controller {


  private final SimpMessagingTemplate template;

  @MessageMapping("/scheduledmsg")
  @SendTo("/topic/message")
  public GreetingMessag connect(HelloMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return GreetingMessag.builder()
            .content("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!").build();

  }



  @Scheduled(cron = "0/15 * * * * *" )
  public void sendMsg() {
    GreetingMessag greetingMessag = GreetingMessag.builder()
            .content("[메세지]" + UuidUtils.getUUID() + " ..... !").build();

    log.debug("cron 15초 이후 실행.. "
            + Thread.currentThread().getName() + " : "
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ss")));

    template.convertAndSend("/topic/message", greetingMessag);
  }
}
