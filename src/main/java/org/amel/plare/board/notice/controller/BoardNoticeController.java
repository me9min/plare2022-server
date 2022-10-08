package org.amel.plare.board.notice.controller;

import java.util.List;

import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.amel.plare.board.notice.service.BoardNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board")
public class BoardNoticeController {
    
    @Autowired
    BoardNoticeService boardNoticeService;
    
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public List<BoardNoticeVO> listBoardNotice() {
        
        return boardNoticeService.listBoardNotice();
    }
}