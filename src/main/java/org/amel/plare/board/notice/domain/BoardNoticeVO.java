package org.amel.plare.board.notice.domain;

import lombok.Data;

@Data
public class BoardNoticeVO {
    
    private int id;
    
    private int views;
    
    private int writerId;
    
    private int dateOfCreated;
    
    private String title;
    
    private String content;
}
