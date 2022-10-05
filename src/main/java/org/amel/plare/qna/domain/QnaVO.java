package org.amel.plare.qna.domain;

import org.amel.plare.BaseEntitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaVO extends BaseEntitiy {
	private int board_question_id;
	
	private int member_id;
	
	private String title;
	
	private String content;
}
