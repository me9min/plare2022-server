package org.amel.plare.board.notice.service;

import java.util.List;

import org.amel.plare.board.notice.dao.BoardNoticeDao;
import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BoardNoticeService {
    
    @Autowired
    BoardNoticeDao boardNoticeDao;
    
    public List<BoardNoticeVO> listBoardNotice() {
        
        return boardNoticeDao.listBoardNotice();
    }
    
    public int insertBoardNotice(@RequestBody BoardNoticeVO boardNotice) {
        
        boardNotice.setIpOfCreated("127.0.0.1");
        boardNotice.setIpOfUpdated("127.0.0.1");
        
        return boardNoticeDao.insertBoardNotice(boardNotice);
    }
    
    public int updateBoardNotice(@RequestBody BoardNoticeVO boardNotice) {
        
        boardNotice.setIpOfUpdated("127.0.0.1");
        
        return boardNoticeDao.updateBoardNotice(boardNotice);
    }
}
