package com.sourjelly.springexample.database.repository;

import com.sourjelly.springexample.database.domain.UsedGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// Mybatis Framework 사용
@Mapper
public interface UsedGoodsRepository {


    // used_goods 모든 행 조회
    public List<UsedGoods> selectUsedGoodsList();


}
