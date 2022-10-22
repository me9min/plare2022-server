package org.amel.plare.store.buy.service;

import org.amel.plare.store.buy.dao.StoreBuyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreBuyService {
    
    @Autowired
    StoreBuyDao storeBuyDao;
    
    public int getCreditById(int id) {
        
        return storeBuyDao.getCreditById(id);
    }
}
