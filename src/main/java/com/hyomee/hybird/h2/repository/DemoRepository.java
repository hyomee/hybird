package com.hyomee.hybird.h2.repository;

import com.hyomee.hybird.h2.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long > {
}
