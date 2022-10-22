package org.amel.plare.store.buy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreBuyDao {
    
    @Autowired
    SqlSession sqlSession;
     
    public int getCreditById(int id) {
        
        return sqlSession.selectOne("StoreBuyeMapper.getCreditById", id);
    }
}
