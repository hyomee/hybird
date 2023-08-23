package com.hyomee.work.workService.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
public class TourlistConditionReqDTO {
  private String title;
  private String zipcode;
  private String addr;
  private String tel;
}
