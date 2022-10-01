package org.amel.plare.store.dao;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreMenuDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public int insertStoreMenu(StoreMenuVO storeMenu) {
        
        return sqlSession.insert("storeMenu.insert", storeMenu);
    }
    
    public List<StoreMenuVO> listStoreMenu() {
        
        return sqlSession.selectList("storeMenu.list");
    }
}
