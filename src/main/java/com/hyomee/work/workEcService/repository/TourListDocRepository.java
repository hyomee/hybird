package com.hyomee.work.workEcService.repository;

import com.hyomee.work.workEcService.doc.TourListDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourListDocRepository extends ElasticsearchRepository<TourListDoc, Long> {
}
