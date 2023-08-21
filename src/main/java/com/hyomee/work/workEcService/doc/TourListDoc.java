package com.hyomee.work.workEcService.doc;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "tourlist")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TourListDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tourListId;

    @Field(type = FieldType.Text)
    private String contentid;
    @Field(type = FieldType.Text)
    private String addr1;
    private String addr2;
    private String areacode;
    private String booktour;
    private String cat1;
    private String cat2;
    private String cat3;
    private String contenttypeid;
    private String createdtime;
    private String firstimage;
    private String firstimage2;
    private String cpyrhtDivCd;
    private String mapx;
    private String mapy;
    private String mlevel;
    private String modifiedtime;
    private String sigungucode;
    private String tel;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String zipcode;
    private String contentid2;
    @Field(type = FieldType.Text)
    private String overview;
}
