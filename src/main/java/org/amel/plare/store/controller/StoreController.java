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

    /**
     * changes no of items per page
     * 페이지당 아이템 개수 변경 -> 페이지는 1로 초기화
     * 
     * @return list of items in shop / 샵 내부 아이템 리스트
     */
    // @RequestMapping(value = "/menu/{pageid}/{noOfItems}", method = RequestMethod.GET)
    // public List<StoreMenuVO> listStoreMenuByPage(@PathVariable int pageid, @PathVariable int noOfItems) {
    //     return storeMenuService.listStoreMenuByPage(pageid, noOfItems);
    // }

    @RequestMapping(value = "/menu/{categoryName}/{pageid}/{noOfItems}", method = RequestMethod.GET)
    public List<StoreMenuVO> categoryView(@PathVariable String categoryName, @PathVariable int pageid, @PathVariable int noOfItems){
        return storeMenuService.categoryView(categoryName, pageid, noOfItems);
    }

}
