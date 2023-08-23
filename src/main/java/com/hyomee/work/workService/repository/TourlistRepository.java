package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.entity.TourlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourlistRepository extends JpaRepository<TourlistEntity, String > , TourlistCustomRespository {
}
