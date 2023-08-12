package com.hyomee.hybird.h2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Setter
@Getter
@Table(name = "TB_DEMO")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class DemoEntity {
    @Id
    private int id;

    private String name;
}

