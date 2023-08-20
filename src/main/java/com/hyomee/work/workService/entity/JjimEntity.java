package com.hyomee.work.workService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_JJIM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JjimEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(length = 32)
  private String jjimId;

  @Column(length = 32)
  private String memberId;

  private int recommendno;
  private int addno;
}
