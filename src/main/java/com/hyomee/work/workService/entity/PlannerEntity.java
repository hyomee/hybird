package com.hyomee.work.workService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "TB_PLANNER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlannerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(length = 32)
  private String planNo;

  @Column(length = 32)
  private String memberId;

  @Column(length = 50)
  private String region;

  @Column(length = 8)
  private String sdate;

  @Column(length = 8)
  private String edate;

  private LocalDateTime regdate;

}
