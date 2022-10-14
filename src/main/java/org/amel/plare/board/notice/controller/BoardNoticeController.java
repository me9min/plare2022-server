package org.amel.plare.board.notice.controller;

import org.amel.plare.BoardStatus;
import org.amel.plare.board.notice.domain.BoardNoticeVO;
import org.amel.plare.board.notice.domain.ListBoardNoticeVO;
import org.amel.plare.board.notice.service.BoardNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board")
public class BoardNoticeController {
    
    @Autowired
    BoardNoticeService boardNoticeService;
    
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ListBoardNoticeVO listBoardNotice(@RequestParam BoardStatus stat, int max,int p) {
        
        return boardNoticeService.listBoardNotice(stat, max, p);
    }
    
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public String insertBoardNotice(@RequestBody BoardNoticeVO boardNotice) {
        
        return "insert된 엔티티수: " + Integer.toString(boardNoticeService.insertBoardNotice(boardNotice));
    }
    
    @RequestMapping(value = "/notice", method = RequestMethod.PATCH)
    public String updateBoardNotice(@RequestBody BoardNoticeVO boardNotice) {
        
        return "update된 엔티티수: " + Integer.toString(boardNoticeService.updateBoardNotice(boardNotice));
    }
    
    @RequestMapping(value = "/notice", method = RequestMethod.PUT)
    public String updateBoardNoticeStatus(@RequestBody BoardNoticeVO boardNotice) {
        
        return "update된 status수: " + Integer.toString(boardNoticeService.updateBoardNoticeStatus(boardNotice));
    }
    
    @RequestMapping(value = "/notice/get", method = RequestMethod.GET)
    public BoardNoticeVO getBoardNoticeById(@RequestParam int id) {
        
        return boardNoticeService.getBoardNoticeById(id);
    }
}
