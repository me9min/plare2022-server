package org.amel.plare.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.amel.plare.qna.domain.QuestionVO;
import org.amel.plare.qna.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/qna/question")
public class QuestionController {
	QuestionService qnaService;

	@RequestMapping(value = "/{boardQuestionId}", method = RequestMethod.GET)
	public ResponseEntity<QuestionVO> getQuestion(@PathVariable int boardQuestionId) {
		QuestionVO qna = qnaService.getQuestion(boardQuestionId);
		return qna != null ? new ResponseEntity(qnaService.getQuestion(boardQuestionId), HttpStatus.OK)
				: new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<QuestionVO>> listQuestion() {
		return new ResponseEntity(qnaService.listQuestion(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<QuestionVO> insertQuestion(@RequestBody QuestionVO qnaVO, HttpServletRequest req) {
		String ip = (String) req.getAttribute("ip");
		qnaVO.setIpOfCreated(ip);
		qnaVO.setIpOfUpdated(ip);

		if (qnaService.insertQuestion(qnaVO) != 1) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(qnaVO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.PATCH)
	public ResponseEntity<Integer> updateQuestion(@RequestBody QuestionVO qnaVO, HttpServletRequest req) {
		String ip = (String) req.getAttribute("ip");
		qnaVO.setIpOfCreated(ip);
		qnaVO.setIpOfUpdated(ip);

		if (qnaService.updateQuestion(qnaVO) != 1) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(0, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteQuestion(@RequestBody QuestionVO qnaVO, HttpServletRequest req) {
		String ip = (String) req.getAttribute("ip");
		qnaVO.setIpOfCreated(ip);
		qnaVO.setIpOfUpdated(ip);

		if (qnaService.deleteQuestion(qnaVO) != 1) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(0, HttpStatus.OK);
	}
	
	
}
