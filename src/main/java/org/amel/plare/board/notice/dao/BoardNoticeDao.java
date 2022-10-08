package org.amel.plare.board.notice.dao;

import java.util.List;

import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardNoticeDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public List<BoardNoticeVO> listBoardNotice() {
        
        return sqlSession.selectList("BoardNoticeMapper.listBoardNotice");
    }

    public int insertBoardNotice() {
        
        return sqlSession.insert("BoardNoticeMapper.insertBoardNotice");
    }

    public int updateBoardNotice() {
        
        return sqlSession.update("BoardNoticeMapper.updateBoardNotice");
    }
}
