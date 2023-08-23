package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.dto.TourlistDTO;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TourlistCustomRespository {
    List<TourlistDTO> findTourlist(String title);
}
