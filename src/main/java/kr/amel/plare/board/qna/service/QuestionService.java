package kr.amel.plare.board.qna.service;

import java.util.List;

import kr.amel.plare.board.qna.dao.QuestionDao;
import kr.amel.plare.board.qna.domain.QuestionVO;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService {
	QuestionDao qnaDao;
	
	public List<QuestionVO> listQuestion() {
		return qnaDao.listQuestion();
	}
	
	public QuestionVO getQuestion(int boardQuestionId) {
		return qnaDao.getQuestion(boardQuestionId);
	}
	
	public int insertQuestion(QuestionVO qnaVO) {
		return qnaDao.insertQuestion(qnaVO);
	}
	
	public int updateQuestion(QuestionVO qnaVO) {
		return qnaDao.updateQuestion(qnaVO);
	}
	
	public int deleteQuestion(QuestionVO qnaVO) {
		return qnaDao.deleteQuestion(qnaVO);
	}
}