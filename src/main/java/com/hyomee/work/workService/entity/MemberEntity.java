package com.hyomee.work.workService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "TB_MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MemberEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(length = 32)
  private String memberId;

  @Column(length = 200)
  private String name;

  @Column(length = 100)
  private String pwd;

  private LocalDate birth;

  @Column(length = 1)
  private String gender;

  @Column(length = 100)
  private String phone;

  @Column(length = 100)
  private String email;
}
