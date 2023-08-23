package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.dto.TourlistDTO;
import com.hyomee.work.workService.entity.QTourlistEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TourlistCustomRespositoryImpl implements TourlistCustomRespository {

    private final JPAQueryFactory jpaQueryFactory;
    private final  QTourlistEntity qTourlistEntity ;

    public TourlistCustomRespositoryImpl(JPAQueryFactory jpaQueryFactory ) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.qTourlistEntity = QTourlistEntity.tourlistEntity;
    }


    @Override
    public List<TourlistDTO> findTourlist(String title) {

        // Tuple 을 객체로 변환 하기 위함
        return jpaQueryFactory.select(Projections.bean(TourlistDTO.class,
                        qTourlistEntity.contentid.as("contentid"),
                        qTourlistEntity.title.as("title"),
                        qTourlistEntity.zipcode.as("zipcode"),
                        qTourlistEntity.addr.as("addr"),
                        qTourlistEntity.addr2.as("addr2"),
                        qTourlistEntity.tel.as("tel"),
                        qTourlistEntity.areacode.as("areacode"),
                        qTourlistEntity.sigungucode.as("sigungucode"),
                        qTourlistEntity.firstimage.as("firstimage"),
                        qTourlistEntity.firstimage.as("firstimage"),
                        qTourlistEntity.firstimage2.as("firstimage2"),
                        qTourlistEntity.overview.as("overview"),
                        qTourlistEntity.mapx.as("mapx"),
                        qTourlistEntity.mapy.as("mapy")))
                .from(qTourlistEntity)
                .where(qTourlistEntity.title.contains(title))
                .fetch();
    }


}
