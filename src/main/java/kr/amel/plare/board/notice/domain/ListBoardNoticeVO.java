package kr.amel.plare.board.notice.domain;

import java.util.List;
import kr.amel.plare.board.BoardStatus;
import lombok.Data;

@Data
public class ListBoardNoticeVO {
    
    private List<BoardNoticeVO> boardNotice;
    
    // 테이블에서 select한 row의 전체수
    private int totalRecord;
    
    // 현재 페이지의 최대레코드수 예) 10개씩보기, 50개씩보기
    private int currentMaxRecord;
    
    // 상태
    private BoardStatus status;
}
