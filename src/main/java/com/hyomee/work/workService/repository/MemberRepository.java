package com.hyomee.work.workService.repository;

import com.hyomee.demo.jpa.entity.DemoEntity;
import com.hyomee.work.workService.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String > {
}
