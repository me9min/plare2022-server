package org.amel.plare.store.controller;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.service.StoreMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/store")
public class StoreController {
    
    @Autowired
    private StoreMenuService storeMenuService;
    
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String insertStoreMenu(@RequestBody StoreMenuVO storeMenu) {
		
		return "insert된 엔티티수: " + Integer.toString(storeMenuService.insertStoreMenu(storeMenu));
	}
    
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<StoreMenuVO> listStoreMenu() {
        
        return storeMenuService.listStoreMenu();
    }
}
