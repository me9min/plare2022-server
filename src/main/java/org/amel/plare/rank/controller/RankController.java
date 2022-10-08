package org.amel.plare.rank.controller;

import java.util.List;

import org.amel.plare.rank.RankService;
import org.amel.plare.rank.domain.GamePlayerVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/rank")
public class RankController {
	RankService rankService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)	
    public List<GamePlayerVO> name(@RequestParam int count, @RequestParam int page) {
		return rankService.selectCredits(page, count);
	}
}
