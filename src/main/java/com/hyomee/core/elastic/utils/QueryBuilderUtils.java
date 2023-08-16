package com.hyomee.core.elastic.utils;

import co.elastic.clients.elasticsearch._types.query_dsl.*;
import com.hyomee.core.utils.ConvertUtils;
import com.hyomee.demo.elastic.dto.DemoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class QueryBuilderUtils {

    public static Query termQuery(String field, String value){
        QueryVariant queryVariant = new TermQuery.Builder().caseInsensitive(true).field(field).value(value).build();
        return new Query(queryVariant);
    }

    public static Query matchQuery(String field, String value){
        QueryVariant queryVariant = new MatchQuery.Builder().field(field).query(value).build();
        return new Query(queryVariant);
    }


    public static List<Query> prepareQueryList(DemoDTO demoDTO) {

        Map<String, String> conditionMap = ConvertUtils.convertToMap(demoDTO);

        List<Query> queries = conditionMap.entrySet().stream()
                .filter(entry->!StringUtils.isEmpty(entry.getValue()))
                .map(entry-> QueryBuilderUtils.termQuery(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        log.debug(" prepareQueryList :: " + queries.toString());

        return queries;
    }

    public static List<Query> matchQueryList(DemoDTO demoDTO) {

        Map<String, String> conditionMap = ConvertUtils.convertToMap(demoDTO);

        List<Query> queries = conditionMap.entrySet().stream()
                .filter(entry->!StringUtils.isEmpty(entry.getValue()))
                .map(entry-> QueryBuilderUtils.matchQuery(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        log.debug(" matchQueryList :: " + queries.toString());

        return queries;
    }

}
