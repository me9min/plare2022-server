package org.amel.plare.Shop;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service layer for shop
 * 샵 서비스 및 로직 레이어
 */
@Service
public class ShopService {

    /** method stub for shop item retrieval from DB
     *
     * @return stub
     */
    public List<Shop> getShopItems() {
        return List.of(new Shop());
    }

}
