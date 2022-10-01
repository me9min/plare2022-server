package org.amel.plare.store.service;

import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.mapper.StoreMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreMenuService {
	
	@Autowired
	StoreMenuMapper storeMenuMapper;

	public int insertStoreMenu(StoreMenuVO storeMenu) {
		
		return storeMenuMapper.insertStoreMenu(storeMenu);
	}
}
