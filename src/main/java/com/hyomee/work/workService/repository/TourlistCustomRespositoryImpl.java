package com.hyomee.work.workService.repository;

import com.hyomee.work.workService.dto.TourlistConditionReqDTO;
import com.hyomee.work.workService.dto.TourlistDTO;
import com.hyomee.work.workService.entity.QTourlistEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.FactoryExpressionBase;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TourlistCustomRespositoryImpl implements TourlistCustomRespository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QTourlistEntity qTourlistEntity = QTourlistEntity.tourlistEntity;


  @Override
    public List<TourlistDTO> findTourlist(TourlistConditionReqDTO tourCondition) {

        // Tuple 을 객체로 변환 하기 위함
        return jpaQueryFactory.select(makeProjectiosBean())
                .from(qTourlistEntity)
                .where(condition(tourCondition))
                .fetch();
    }

    @Override
    public Page<TourlistDTO> findTourlistPage(TourlistConditionReqDTO tourCondition, Pageable pageable) {

        // Querydsl이 제공하는 fetchResults() 를 사용하면 내용과 전체 카운트를 한번에 조회할 수 있다.
        // (실제 쿼리는 2번 호출
        List<TourlistDTO> tourlistDTOs = jpaQueryFactory.select(makeProjectiosBean())
                .from(qTourlistEntity)
                .where(condition(tourCondition))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = jpaQueryFactory.select(qTourlistEntity.count())
                .from(qTourlistEntity)
                .where(condition(tourCondition));

        return PageableExecutionUtils.getPage(tourlistDTOs, pageable, countQuery:: fetchOne );
    }

    @Override
    public Page<TourlistDTO> findTourlistPageComplex(TourlistConditionReqDTO tourCondition, Pageable pageable) {
        List<TourlistDTO> tourlistDTOs = jpaQueryFactory.select(makeProjectiosBean())
                .from(qTourlistEntity)
                .where(condition(tourCondition))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = jpaQueryFactory.select(qTourlistEntity.count())
                .from(qTourlistEntity)
                .where(condition(tourCondition));

        return PageableExecutionUtils.getPage(tourlistDTOs, pageable, countQuery:: fetchOne );
    }



    private FactoryExpressionBase<TourlistDTO> makeProjectiosBean() {
        return Projections.bean(TourlistDTO.class,
                qTourlistEntity.contentid ,
                qTourlistEntity.title ,
                qTourlistEntity.zipcode ,
                qTourlistEntity.addr ,
                qTourlistEntity.addr2 ,
                qTourlistEntity.tel ,
                qTourlistEntity.areacode ,
                qTourlistEntity.sigungucode ,
                qTourlistEntity.firstimage ,
                qTourlistEntity.firstimage ,
                qTourlistEntity.firstimage2 ,
                qTourlistEntity.overview ,
                qTourlistEntity.mapx ,
                qTourlistEntity.mapy );
    }

    private ConstructorExpression<TourlistDTO> makeProjectiosConstructor() {
        return Projections.constructor(TourlistDTO.class, qTourlistEntity);
    }


    private BooleanBuilder condition(TourlistConditionReqDTO tourCondition) {
        return new BooleanBuilder(ExpressionUtils.allOf(titleContains(tourCondition.getTitle()),
                zipcodeContains(tourCondition.getZipcode()),
                addrContains(tourCondition.getAddr()),
                telContains(tourCondition.getTel())) );

    }

    private BooleanExpression titleContains(String value) {
        return StringUtils.isNotEmpty(value) ?
                qTourlistEntity.title.contains(value) :
                null;
    }

    private BooleanExpression zipcodeContains(String value) {
        return StringUtils.isNotEmpty(value) ?
                qTourlistEntity.zipcode.contains(value) :
                null;
    }

    private BooleanExpression addrContains(String value) {
        return StringUtils.isNotEmpty(value) ?
                qTourlistEntity.addr.contains(value) :
                null;
    }

    private BooleanExpression telContains(String value) {
        return StringUtils.isNotEmpty(value) ?
                qTourlistEntity.tel.contains(value) :
                null;
    }

}
