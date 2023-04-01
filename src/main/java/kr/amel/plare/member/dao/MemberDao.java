package kr.amel.plare.member.dao;

import kr.amel.plare.member.domain.MemberVO;
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

	public MemberVO selectOneMember(String authId) {
		
		return sqlSession.selectOne("MemberMapper.selectOneMember", authId);
	}
	
	public String findPasswordById(String authId) {
		
		return sqlSession.selectOne("MemberMapper.findPasswordById", authId);
	}

	public int checkId(String authId) {

		return sqlSession.selectOne("MemberMapper.checkId", authId);
	}
}