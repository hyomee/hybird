package com.hyomee.work.workService.controller;

import com.hyomee.core.utils.ResponseUtils;
import com.hyomee.work.workService.service.tourlist.TourListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tourlist")
public class TourListController {

    private final TourListService tourListService;

    @GetMapping("/qdsl/{title}")
    public ResponseEntity getTourlistByTitleContains(@PathVariable String title) {
        return ResponseUtils.completed(tourListService.getTourlistByTitle(title));
    }
}
