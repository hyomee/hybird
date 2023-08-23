package com.hyomee.work.workService.service.tourlist;

import com.hyomee.work.workService.dto.TourlistConditionReqDTO;
import com.hyomee.work.workService.dto.TourlistDTO;
import com.hyomee.work.workService.repository.TourlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TourListService {
    private final TourlistRepository tourlistRepository;

    public List<TourlistDTO> findTourlist(TourlistConditionReqDTO tourlistConditionReqDTO) {
        return tourlistRepository.findTourlist(tourlistConditionReqDTO);
    }
}
