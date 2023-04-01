package kr.amel.plare.board.qna.domain;

import kr.amel.plare.board.BaseEntitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerVO extends BaseEntitiy {
	private int boardAnswerId;
	
	private int memberId;
	
	private int views;
	
	private String title;
	
	private String content;
}
