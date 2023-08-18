package com.hyomee.core.jpa.utils;

import com.querydsl.core.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

public class PageUtils {

    @Value("${pageing.page:0}")
    private static int page;
    @Value("${pageing.size:10}")
    private static int size;

    @Value("${pageing.direction:asc}")
    private static String direction ;

    @Value("${pageing.properties")
    private static String properties;


    public static <T> Pageable getPageable(T source) {
        Set<Field> fields =  ReflectionUtils.getFields(source.getClass());

        int page = PageUtils.page;
        int size = PageUtils.size;
        Sort.Direction direction = Sort.Direction.ASC;
        String[] properties = null;

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if ("page".equals(field.getName())) page = getPageValue(  field,  source );
                if ("size".equals(field.getName())) size = getSizeValue(  field,  source );
                if ("direction".equals(field.getName())) direction = getDirectionValue(  field,  source );
                if ("properties".equals(field.getName()))  properties = getProperties( field,  source );
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        return  PageRequest.of(page, size, direction, properties);
    }

    public static <T> Pageable getPageable() {

        return  PageRequest.of(page, size, Sort.Direction.valueOf(direction), properties);
    }

    private static <T> int getPageValue(Field field, T source ) throws IllegalAccessException {
        if ("page".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                return (int) field.get(source);
            }
        }
        return PageUtils.page;
    }

    private static <T> int getSizeValue(Field field, T source ) throws IllegalAccessException {
        if ("size".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                return (int) field.get(source);
            }
        }
        return PageUtils.size;
    }

    private static <T> Sort.Direction getDirectionValue(Field field, T source ) throws IllegalAccessException {
        if ("direction".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                return Sort.Direction.valueOf((String) field.get(source));
            }
        }
        return Sort.Direction.ASC;
    }

    private static <T> String[]  getProperties(Field field, T source ) throws IllegalAccessException {
        if ("properties".equals(field.getName())) {
            if (Objects.nonNull(field.get(source))) {
                 return field.get(source).toString().split(",");
            }
        }
        return null;
    }
}
