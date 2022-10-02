package org.amel.plare.store.controller;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuPageVO;
import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.service.StoreMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/** controller class for store
 *  스토어 컨트롤러 API 클래스
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    /** composed service class object for store
     *  링크된 스토어 서비스 클래스
     */
    private final StoreMenuService storeMenuService;

    @Autowired
    public StoreController(StoreMenuService storeMenuService) {
        this.storeMenuService = storeMenuService;
    }

    /** add into shop menu
     * 샵 아이템 추가
     * @param storeMenu item object 아이템 오브젝
     * @return no of items / 현재 추가된 아이템 개수
     */
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String insertStoreMenu(@RequestBody StoreMenuVO storeMenu) {
		
		return "insert된 엔티티수: " + Integer.toString(storeMenuService.insertStoreMenu(storeMenu));
	}

    /** lists menu of store
     * 샵 메뉴 리스트
     * @return list of items in shop / 샵 내부 아이템 리스트
     */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public StoreMenuPageVO listStoreMenu(@RequestBody StoreMenuPageVO page, @PathVariable int pageid) {
        if(page == null) {
            page = StoreMenuPageVO.DEFAULT;
        }
        if(pageid > page.getMaxPage()) {
            throw new IllegalArgumentException("page number exceeds max");
        }

        return storeMenuService.listStoreMenuByPage(page, pageid);
    }

}
