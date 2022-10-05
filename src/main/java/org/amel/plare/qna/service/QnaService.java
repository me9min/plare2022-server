package org.amel.plare.qna.service;

import java.util.List;

import org.amel.plare.qna.dao.QnaDao;
import org.amel.plare.qna.domain.QnaVO;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QnaService {
	QnaDao qnaDao;
	
	public List<QnaVO> listQuestion() {
		return qnaDao.listQuestion();
	}
}
