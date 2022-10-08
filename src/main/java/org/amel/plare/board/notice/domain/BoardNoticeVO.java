package org.amel.plare.board.notice.domain;

import java.util.Date;

import org.amel.plare.BoardStatus;

import lombok.Data;

@Data
public class BoardNoticeVO {
    
    private int noticeId;
    
    private int memberId;
    
    private String title;
    
    private String content;
    
    private int views;
    
    private Date dateOfCreated;
    
    private String ipOfCreated;
    
    private Date dateOfUpdated;
    
    private String ipOfUpdated;
    
    private int memberIdOfUpdated;
    
    private BoardStatus status;
}
