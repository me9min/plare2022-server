package kr.amel.plare.board.qna.domain;

import kr.amel.plare.board.BaseEntitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionVO extends BaseEntitiy {
	private int boardQuestionId;
	
	private int memberId;
	
	private int views;
	
	private String title;
	
	private String content;
}