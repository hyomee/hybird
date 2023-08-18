package com.hyomee.core.elastic.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageDTO {

  private long total;
  private int pageNumber;
  private int pageCount;
  private int pageSize;
}
