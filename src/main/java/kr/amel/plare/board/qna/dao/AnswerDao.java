package kr.amel.plare.board.qna.dao;

import java.util.List;

import kr.amel.plare.board.qna.domain.AnswerVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AnswerDao {
	SqlSession sqlsession;
	
	public List<AnswerVO> listAnswer() {
		return sqlsession.selectList("AnswerMapper.listAnswer");
	}
	
	public AnswerVO getAnswer(int boardAnswerId) {
		return sqlsession.selectOne("AnswerMapper.getAnswer",boardAnswerId);
	}
	
	public int insertAnswer(AnswerVO qnaVO) {
		return sqlsession.insert("AnswerMapper.insertAnswer", qnaVO);
	}
	
	public int updateAnswer(AnswerVO qnaVO) {
		return sqlsession.update("AnswerMapper.updateAnswer", qnaVO);
	}
	
	public int deleteAnswer(AnswerVO qnaVO) {
		return sqlsession.update("AnswerMapper.deleteAnswer", qnaVO);
	}
}
