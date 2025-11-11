package com.sourjelly.springexample.mybatis.repository;

import com.sourjelly.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewRepository {

    // new_review 테이블에서  전달 받은 id 와 일치하는 행 조회
    public Review selectReview(@Param("id") int id);
}
