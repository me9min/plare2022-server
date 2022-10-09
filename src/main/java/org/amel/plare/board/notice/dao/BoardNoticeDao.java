package org.amel.plare.board.notice.dao;

import java.util.List;

import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class BoardNoticeDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public List<BoardNoticeVO> listBoardNotice(String status) {
        
        return sqlSession.selectList("BoardNoticeMapper.listBoardNotice", status);
    }

    public int insertBoardNotice(BoardNoticeVO boardNotice) {
        
        return sqlSession.insert("BoardNoticeMapper.insertBoardNotice", boardNotice);
    }

    public int updateBoardNotice(BoardNoticeVO boardNotice) {
        
        return sqlSession.update("BoardNoticeMapper.updateBoardNotice", boardNotice);
    }
    
    public int updateBoardNoticeStatus(BoardNoticeVO boardNotice) {
        
        return sqlSession.update("BoardNoticeMapper.updateBoardNoticeStatus", boardNotice);
    }
}
