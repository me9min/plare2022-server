package org.amel.plare.store.buy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreBuyDao {
    
    @Autowired
    SqlSession sqlSession;
     
    public int getCreditsById(int id) {
        
        return sqlSession.selectOne("StoreBuyeMapper.getCreditsById", id);
    }
    
    public int updateCreditsById(int id) {
        
        return sqlSession.update("StoreBuyeMapper.updateCreditsById", id);
    }
    
    public int getIdBySteamid(String steamid) {
        
        return sqlSession.selectOne("StoreBuyeMapper.getIdBySteamid", steamid);
    }
}
