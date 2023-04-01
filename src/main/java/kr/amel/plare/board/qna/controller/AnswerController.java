package kr.amel.plare.board.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.amel.plare.board.qna.domain.AnswerVO;
import kr.amel.plare.board.qna.service.AnswerService;
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
@RequestMapping("/qna/answer")
public class AnswerController {
	AnswerService answerService;

	@RequestMapping(value = "/{boardAnswerId}", method = RequestMethod.GET)
	public ResponseEntity<AnswerVO> getAnswer(@PathVariable int boardAnswerId) {
		AnswerVO qna = answerService.getAnswer(boardAnswerId);
		return qna != null ? new ResponseEntity(answerService.getAnswer(boardAnswerId), HttpStatus.OK)
				: new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<AnswerVO>> listAnswer() {
		return new ResponseEntity(answerService.listAnswer(), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<AnswerVO> insertAnswer(@RequestBody AnswerVO qnaVO, HttpServletRequest req) {
		String ip = (String) req.getAttribute("ip");
		qnaVO.setIpOfCreated(ip);
		qnaVO.setIpOfUpdated(ip);

		if (answerService.insertAnswer(qnaVO) != 1) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(qnaVO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.PATCH)
	public ResponseEntity<Integer> updateAnswer(@RequestBody AnswerVO qnaVO, HttpServletRequest req) {
		String ip = (String) req.getAttribute("ip");
		qnaVO.setIpOfCreated(ip);
		qnaVO.setIpOfUpdated(ip);

		if (answerService.updateAnswer(qnaVO) != 1) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(0, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteAnswer(@RequestBody AnswerVO qnaVO, HttpServletRequest req) {
		String ip = (String) req.getAttribute("ip");
		qnaVO.setIpOfCreated(ip);
		qnaVO.setIpOfUpdated(ip);

		if (answerService.deleteAnswer(qnaVO) != 1) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity(0, HttpStatus.OK);
	}

}
