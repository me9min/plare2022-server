package org.amel.plare.board.notice.domain;

import java.util.Date;

import org.amel.plare.BoardStatus;

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
