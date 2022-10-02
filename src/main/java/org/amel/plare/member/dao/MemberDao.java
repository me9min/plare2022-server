package org.amel.plare.member.dao;

import org.amel.plare.member.domain.MemberLoginVO;
import org.amel.plare.member.domain.MemberVO;
import org.amel.plare.store.domain.StoreMenuVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    
    @Autowired
    SqlSession sqlSession;

    public int insertMember(MemberVO member) {

        return sqlSession.insert("MemberMapper.insertMember", member);
    }

    public MemberVO selectOneMember(String authId){
        return sqlSession.selectOne("MemberMapper.selectOneMember", authId);
    }
}
