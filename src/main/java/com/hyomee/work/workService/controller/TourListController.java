package com.hyomee.work.workService.controller;

import com.hyomee.core.utils.ResponseUtils;
import com.hyomee.work.workService.dto.TourlistConditionReqDTO;
import com.hyomee.work.workService.service.tourlist.TourListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tourlist")
public class TourListController {

    private final TourListService tourListService;

    @GetMapping("/qdsl")
    public ResponseEntity getTourlistByTitleContains(@RequestBody TourlistConditionReqDTO tourlistConditionReqDTO) {
        return ResponseUtils.completed(tourListService.findTourlist(tourlistConditionReqDTO));
    }
}
