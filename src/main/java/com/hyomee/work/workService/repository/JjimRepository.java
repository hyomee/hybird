package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.entity.JjimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JjimRepository extends JpaRepository<JjimEntity, String > {
}
