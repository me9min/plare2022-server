package org.amel.plare.qna.dao;

import java.util.List;

import org.amel.plare.qna.domain.QnaVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class QnaDao {
	SqlSession sqlsession;
	
	public List<QnaVO> listQuestion() {
		return sqlsession.selectList("QnaMapper.listQuestion");
	}
}
