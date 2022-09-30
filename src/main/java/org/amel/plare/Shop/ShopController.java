package org.amel.plare.Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Shop controller layer
 * 샵 컨트롤러 레이어
 */
@RestController
@RequestMapping("/store/menu")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    /** returns all Shop instances in a ArrayList
     * 샵 오브젝 내부 아이템 전부 콜
     * @return
     */
    public List<Shop> menu() {
        return shopService.getShopItems();
    }
}
