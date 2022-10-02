package org.amel.plare.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public String findPasswordById(String id) {
        
        return sqlSession.selectOne("member.insert", id);
    }
}
