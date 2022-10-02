package org.amel.plare.board.notice.service;

import java.util.List;

import org.amel.plare.board.notice.dao.BoardNoticeDao;
import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardNoticeService {
    
    @Autowired
    BoardNoticeDao boardNoticeDao;
    
    public List<BoardNoticeVO> listBoardNotice() {
        
        return boardNoticeDao.listBoardNotice();
    }
}
