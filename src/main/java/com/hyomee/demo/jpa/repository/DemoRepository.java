package com.hyomee.demo.jpa.repository;

import com.hyomee.demo.jpa.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long > {

    Page<DemoEntity> findByNameContains(String name, Pageable pageable);


}
