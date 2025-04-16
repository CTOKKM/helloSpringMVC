package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// OfferService 클래스는 비즈니스 로직을 담당하며, Controller와 DAO 사이의 중간 역할을 합니다.
// 주로 데이터 처리 전후의 추가 로직이 있다면 이 클래스에 정의합니다.
public class OfferService {

    // DAO 객체를 주입받아 데이터베이스와의 통신을 처리
    @Autowired
    private OfferDao offerDao;

    // 모든 Offer 데이터를 조회하여 반환 (Controller에서 호출됨)
    public List<Offer> getAllOffers() {
        return offerDao.getOffers();
    }

    // 새로운 Offer 데이터를 DB에 저장 (Controller에서 호출됨)
    public void insertOffer(Offer offer) {
        offerDao.insert(offer);
    }
}