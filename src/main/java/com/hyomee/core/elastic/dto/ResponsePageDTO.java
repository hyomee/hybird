package com.hyomee.core.elastic.dto;

import com.hyomee.demo.es.doc.Article;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@Builder
public class ResponsePageDTO {
  public PageDTO page;
  public Object content;

  public static ResponsePageDTO setResponsePageDTO(Page<?> page) {

    return ResponsePageDTO.builder()
            .page(PageDTO.builder()
                    .total( page.getTotalElements())
                    .pageCount(page.getTotalPages())
                    .pageNumber(page.getPageable().getPageNumber())
                    .pageSize(page.getPageable().getPageSize())
                    .build())
            .content(page.getContent())
            .build();

  }

}
