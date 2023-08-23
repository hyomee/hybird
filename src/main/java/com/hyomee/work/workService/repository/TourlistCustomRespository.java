package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.dto.TourlistConditionReqDTO;
import com.hyomee.work.workService.dto.TourlistDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TourlistCustomRespository {
    List<TourlistDTO> findTourlist(TourlistConditionReqDTO tourlistConditionReqDTO);
    Page<TourlistDTO> findTourlistPage(TourlistConditionReqDTO tourlistConditionReqDTO,
                                       Pageable pageable);
    Page<TourlistDTO> findTourlistPageComplex(TourlistConditionReqDTO tourlistConditionReqDTO, Pageable pageable);
}
