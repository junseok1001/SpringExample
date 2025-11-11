package com.sourjelly.springexample.database.service;

import com.sourjelly.springexample.database.domain.UsedGoods;
import com.sourjelly.springexample.database.repository.UsedGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 부가적인 기능수행
// 데이터 가공 처리
@Service
public class UsedGoodsService {

    // 의존성 주입 - DI
    // spring framework가 직접 객체 생성 관리 해준다
    // 효율적인 관리 / framework 가 개발자를 못믿고 그냥 나 믿고해 라고 생각하면 편함.(싱글턴 패턴으로 생성)
    @Autowired
    private UsedGoodsRepository usedGoodsRepository;

    // 중고 거래 게시글 리스트 얻어오기
    public List<UsedGoods> getUsedGoodsList(){

        // used_goods 모든 행 조회 결과
        List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();

        return usedGoodsList;

    }
}
