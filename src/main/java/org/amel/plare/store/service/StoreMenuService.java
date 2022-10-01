package org.amel.plare.store.service;

import java.util.List;

import org.amel.plare.store.dao.StoreMenuDao;
import org.amel.plare.store.domain.StoreMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreMenuService {
    
    @Autowired
    StoreMenuDao storeMenuDao;
    
	public int insertStoreMenu(StoreMenuVO storeMenu) {
	    
	    return storeMenuDao.insertStoreMenu(storeMenu);
	}
	
    public List<StoreMenuVO> listStoreMenu() {
        
        return storeMenuDao.listStoreMenu();
    }
}
