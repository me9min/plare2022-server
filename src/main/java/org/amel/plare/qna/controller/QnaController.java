package org.amel.plare.qna.controller;

import java.util.List;

import org.amel.plare.qna.domain.QnaVO;
import org.amel.plare.qna.service.QnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/qna")
public class QnaController {
	QnaService qnaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<QnaVO>> signupMember() {

		return new ResponseEntity(qnaService.listQuestion(), HttpStatus.OK);
	}

}
