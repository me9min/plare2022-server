package org.amel.plare.board.notice.domain;

import org.amel.plare.board.BoardStatus;

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
