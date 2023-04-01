package kr.amel.plare.board.notice.dao;

import java.util.List;
import kr.amel.plare.board.BoardStatus;
import kr.amel.plare.board.notice.domain.BoardNoticeVO;
import kr.amel.plare.board.notice.domain.ListBoardNoticeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardNoticeDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public List<BoardNoticeVO> listBoardNotice(ListBoardNoticeVO listBoardNotice) {
        
        return sqlSession.selectList("BoardNoticeMapper.listBoardNotice", listBoardNotice);
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
    
    public int countBoardNotice(BoardStatus status) {
        
        return sqlSession.selectOne("BoardNoticeMapper.countBoardNotice");
    }
    
    public BoardNoticeVO getBoardNoticeById(int id) {
        
        return sqlSession.selectOne("BoardNoticeMapper.getBoardNoticeById", id);
    }
}
