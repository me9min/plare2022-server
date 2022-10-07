package org.amel.plare.store.controller;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.service.StoreMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller class for store
 * 스토어 컨트롤러 API 클래스
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    /**
     * composed service class object for store
     * 링크된 스토어 서비스 클래스
     */
    private final StoreMenuService storeMenuService;

    @Autowired
    public StoreController(StoreMenuService storeMenuService) {
        this.storeMenuService = storeMenuService;
    }

    /**
     * add into shop menu
     * 샵 아이템 추가
     * @param storeMenu item object 아이템 오브젝
     * @return no of items / 현재 추가된 아이템 개수
     */
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String insertStoreMenu(@RequestBody StoreMenuVO storeMenu) {

        return "insert된 엔티티수: " + Integer.toString(storeMenuService.insertStoreMenu(storeMenu));
    }

    /** provides a json file containing search_items based on URL, paged.
     * 검색된 아이템을 URL 기반으로 리턴
     * @param categoryName 카테고리 이름 -> 0(전부) 1(기본아이템), 2(이벤트아이템) -> 추후 변경 가능
     * @param pageid 가고싶은 페이지 번호
     * @param noOfItems 페이지당 아이템 개수
     * 
     * @return list of items in shop / 샵 내부 아이템 리스트
     */
    @RequestMapping(value = "/menu/{categoryName}/{pageid}/{noOfItems}", method = RequestMethod.GET)
    public List<StoreMenuVO> ItemView(@PathVariable String categoryName, @PathVariable int pageid, @PathVariable int noOfItems){
        return storeMenuService.ItemView(categoryName, pageid, noOfItems);
    }


}
