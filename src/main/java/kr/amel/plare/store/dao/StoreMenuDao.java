package kr.amel.plare.store.dao;

import java.util.List;

import kr.amel.plare.store.domain.StoreMenuVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class StoreMenuDao {
    SqlSession sqlSession;
    
    public List<StoreMenuVO> listStoreMenu(StoreMenuVO storeMenuVO) {
    	return sqlSession.selectList("storeMenu.listStoreMenu", storeMenuVO);
    }
}
