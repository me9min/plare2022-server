package org.amel.plare.board.notice.dao;

import java.util.List;

import org.amel.plare.BoardStatus;
import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class BoardNoticeDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public List<BoardNoticeVO> listBoardNotice() {
        
        BoardNoticeVO boardNotice = null;
        boardNotice.setStatus(BoardStatus.PUBLIC);
        
        return sqlSession.selectList("BoardNoticeMapper.listBoardNotice", boardNotice);
    }

    public int insertBoardNotice(@RequestBody BoardNoticeVO boardNotice) {
        
        return sqlSession.insert("BoardNoticeMapper.insertBoardNotice", boardNotice);
    }

    public int updateBoardNotice(@RequestBody BoardNoticeVO boardNotice) {
        
        return sqlSession.update("BoardNoticeMapper.updateBoardNotice", boardNotice);
    }
}
