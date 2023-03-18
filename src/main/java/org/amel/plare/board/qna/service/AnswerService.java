package org.amel.plare.board.qna.service;

import java.util.List;

import org.amel.plare.board.qna.dao.AnswerDao;
import org.amel.plare.board.qna.domain.AnswerVO;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnswerService {
	AnswerDao answerDao;
	
	public List<AnswerVO> listAnswer() {
		return answerDao.listAnswer();
	}
	
	public AnswerVO getAnswer(int boardAnswerId) {
		return answerDao.getAnswer(boardAnswerId);
	}
	
	public int insertAnswer(AnswerVO qnaVO) {
		return answerDao.insertAnswer(qnaVO);
	}
	
	public int updateAnswer(AnswerVO qnaVO) {
		return answerDao.updateAnswer(qnaVO);
	}
	
	public int deleteAnswer(AnswerVO qnaVO) {
		return answerDao.deleteAnswer(qnaVO);
	}
}
