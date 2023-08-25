package com.hyomee.demo.requrstandresponse.websocketStomp.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GreetingMessag {
  @JsonProperty("content")
  private String content;
}
