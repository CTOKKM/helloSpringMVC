package kr.ac.hansung.cse.controller;

// 이 컨트롤러는 사용자 요청을 처리하고 OfferService를 통해 비즈니스 로직을 수행합니다.
// URL 매핑: /offers, /createoffer, /docreate
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OfferController {
    // OfferService는 비즈니스 로직을 담당하는 서비스 클래스입니다.
    // @Autowired를 사용하면 Spring이 자동으로 의존성 주입을 수행합니다.
    @Autowired //
    private OfferService offerService;

    // /offers 요청 처리: OfferService에서 모든 offer를 가져와 모델에 추가하고 offers.jsp 뷰로 전달
    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers", offers); // key(id_offers), value(offers) 값 전달

        return "offers";
    }

    // /createoffer 요청 처리: 빈 Offer 객체를 모델에 추가해 폼에 바인딩할 수 있도록 준비
    @GetMapping("/createoffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "createoffer";
    }

    // /docreate 요청 처리: 사용자가 제출한 Offer 객체를 검증하고, 유효하면 insert 후 offercreated.jsp로 이동
    // 유효성 검증 실패 시에는 다시 createoffer.jsp로 이동
    @PostMapping("docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
        System.out.println(offer);

        // 폼 유효성 검사가 실패했을 경우 오류 메시지를 출력하고 다시 입력 폼으로 이동
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }

        // 검증 통과 시 OfferService를 통해 DB에 offer를 저장
        offerService.insertOffer(offer);
        return "offercreated";
    }

}
