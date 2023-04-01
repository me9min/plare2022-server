package kr.amel.plare.board.notice.domain;

import java.time.LocalDateTime;
import kr.amel.plare.board.BoardStatus;
import lombok.Data;

@Data
public class BoardNoticeVO {
    
    private int noticeId;
    
    private int memberId;
    
    private String title;
    
    private String content;
    
    private int views;
    
    private LocalDateTime dateOfCreated;
    
    private String ipOfCreated;
    
    private LocalDateTime dateOfUpdated;
    
    private String ipOfUpdated;
    
    private int memberIdOfUpdated;
    
    private BoardStatus status;
}
