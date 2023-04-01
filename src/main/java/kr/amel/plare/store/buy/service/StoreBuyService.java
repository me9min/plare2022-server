package kr.amel.plare.store.buy.service;

import kr.amel.plare.store.buy.dao.StoreBuyDao;
import kr.amel.plare.store.buy.domain.StoreBuyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreBuyService {
    
    @Autowired
    StoreBuyDao storeBuyDao;
    
    public int storeBuyCart(StoreBuyVO storeBuy) {
        
        //storeBuyDao.getCreditsById();
        
        return 1;
    }
}
