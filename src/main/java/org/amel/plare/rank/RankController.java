package org.amel.plare.rank;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amel.plare.vo.GamePlayerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ranking")
public class RankController {

	@Autowired
	private RankServiceImpl rankService;

	@GetMapping("/list")
	public ModelAndView List(HttpServletRequest request, HttpServletResponse response, Model m) {
		
		int page = 5;
		
		if(request.getParameter("paging_count") != null) {
			page = Integer.parseInt(request.getParameter("paging_count"));
		}
		
		java.util.List<GamePlayerVO> gameList = rankService.selectCredits(page);
		ModelAndView rankList = new ModelAndView();
		rankList.addObject("gameList", gameList);
		rankList.setViewName("/ranking/list");
		return rankList;
	}

}
