package kr.amel.plare.board.notice.service;

import kr.amel.plare.board.BoardStatus;
import kr.amel.plare.board.notice.dao.BoardNoticeDao;
import kr.amel.plare.board.notice.domain.BoardNoticeVO;
import kr.amel.plare.board.notice.domain.ListBoardNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardNoticeService {
    
    @Autowired
    BoardNoticeDao boardNoticeDao;
    
    public ListBoardNoticeVO listBoardNotice(BoardStatus stat, int max,int p) {
        
        ListBoardNoticeVO listBoardNotice = new ListBoardNoticeVO();
        
        // totalRecord에 select시작 레코드 계산후 임시저장
        listBoardNotice.setTotalRecord(max*(p-1));
        listBoardNotice.setCurrentMaxRecord(max);
        listBoardNotice.setStatus(stat);
        
        // 페이지당 레코드수와 페이지를 넘겨 select한다
        listBoardNotice.setBoardNotice(boardNoticeDao.listBoardNotice(listBoardNotice));
        // listBoardNotice의 currentMaxRecord에다 boardNotice의 레코드수를 넣는다
        listBoardNotice.setTotalRecord(boardNoticeDao.countBoardNotice(stat));
        
        return listBoardNotice;
    }
    
    public int insertBoardNotice(BoardNoticeVO boardNotice) {
        
        boardNotice.setIpOfCreated("127.0.0.1");
        boardNotice.setIpOfUpdated("127.0.0.1");
        
        return boardNoticeDao.insertBoardNotice(boardNotice);
    }
    
    public int updateBoardNotice(BoardNoticeVO boardNotice) {
        
        boardNotice.setIpOfUpdated("127.0.0.1");
        
        return boardNoticeDao.updateBoardNotice(boardNotice);
    }
    
    public int updateBoardNoticeStatus(BoardNoticeVO boardNotice) {
        
        return boardNoticeDao.updateBoardNoticeStatus(boardNotice);
    }
    
    public BoardNoticeVO getBoardNoticeById(int id) {
        
        return boardNoticeDao.getBoardNoticeById(id);
    }
}
