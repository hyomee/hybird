package com.hyomee.work.workService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "TB_TOURLIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourlistEntity {
  @Id
  @Column(length = 32)
  private String contentid;

  @Column(length = 500)
  private String title;

  @Column(length = 10)
  private String zipcode;

  @Column(length = 1000)
  private String addr;

  @Column(length = 1000)
  private String addr2;

  @Column(length = 100)
  private String tel;

  @Column(length = 5)
  private String areacode;

  @Column(length = 5)
  private String sigungucode;

  @Column(length = 500)
  private String firstimage;

  @Column(length = 500)
  private String firstimage2;

  @Column(length = 65535)
  private String overview;

  @Column(length = 20)
  private String mapx;

  @Column(length = 20)
  private String mapy;
}
