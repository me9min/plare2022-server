package kr.amel.plare.board.notice.domain;

import kr.amel.plare.board.BoardStatus;

import lombok.Data;

@Data
public class BoardNoticePageVO {
    
    private int memberId;
    
    private String title;
    
    private String content;
    
    private BoardStatus status;
    
    private int currentPage;
    
    private int maxPage;
    
    private int limitList;
}
