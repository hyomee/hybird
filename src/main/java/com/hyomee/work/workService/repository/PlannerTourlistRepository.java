package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.entity.PlannerTourlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannerTourlistRepository extends JpaRepository<PlannerTourlistEntity, String > {
}
