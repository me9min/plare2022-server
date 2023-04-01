package kr.amel.plare.board.qna.dao;

import java.util.List;

import kr.amel.plare.board.qna.domain.QuestionVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class QuestionDao {
	SqlSession sqlsession;
	
	public List<QuestionVO> listQuestion() {
		return sqlsession.selectList("QuestionMapper.listQuestion");
	}
	
	public QuestionVO getQuestion(int boardQuestionId) {
		return sqlsession.selectOne("QuestionMapper.getQuestion",boardQuestionId);
	}
	
	public int insertQuestion(QuestionVO qnaVO) {
		return sqlsession.insert("QuestionMapper.insertQuestion", qnaVO);
	}
	
	public int updateQuestion(QuestionVO qnaVO) {
		return sqlsession.update("QuestionMapper.updateQuestion", qnaVO);
	}
	
	public int deleteQuestion(QuestionVO qnaVO) {
		return sqlsession.update("QuestionMapper.deleteQuestion", qnaVO);
	}
}
