package com.hyomee.work.workService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_PLANNER_TOURLIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlannerTourlistEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(length = 32)
  private String tourNo;

  @Column(length = 32)
  private String planNo;
  private int tourSeq;  // tourNo에 대한 MAX
  private int tourDay;
}
