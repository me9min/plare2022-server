package org.amel.plare.store.controller;

import org.amel.plare.store.domain.StoreMenuVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    
	@GetMapping("/menu")
	public String insertStoreMenu(StoreMenuVO storeMenu) {
		
		return "테스트";
	}
}
