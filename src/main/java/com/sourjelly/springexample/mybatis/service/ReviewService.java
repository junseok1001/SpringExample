package com.sourjelly.springexample.mybatis.service;

import com.sourjelly.springexample.mybatis.domain.Review;
import com.sourjelly.springexample.mybatis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    // new_review 테이블에서  전달 받은 id 와 일치하는 행 조회
    public Review getReview(int id){

        // new_reivew 테이블에서 id 가 3인 행 조회
        Review review = reviewRepository.selectReview(id);
        return review;

    }
}
