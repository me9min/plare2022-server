package org.amel.plare.store.controller;

import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.mapper.StoreMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {
    
    @Autowired
    private StoreMenuMapper storeMenuMapper;
    
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
	public int insertStoreMenu(StoreMenuVO storeMenu) {
		
		return storeMenuMapper.insertStoreMenu(storeMenu);
	}
}
