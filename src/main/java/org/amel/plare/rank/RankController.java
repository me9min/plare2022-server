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
		int start = 1;
		int end = 0;
		int max = 0;
		int pageList = 5;
		int limitStart = 1;
		
		if(request.getParameter("limitStart") != null) {
			limitStart = Integer.parseInt(request.getParameter("limitStart"));
		}
		
	
		if (request.getParameter("start") != null) {
			start = Integer.parseInt(request.getParameter("start"));
		}

		max = (rankService.pageCount() / pageList) + (rankService.pageCount() % pageList);

		if (max >= (start + pageList - 1)) {
			end = start + pageList - 1;
		}else {
			end = max;
		}

		if (request.getParameter("paging_count") != null) {
			page = Integer.parseInt(request.getParameter("paging_count"));
		}

		java.util.List<GamePlayerVO> gameList = rankService.selectCredits(limitStart, pageList);
		ModelAndView rankList = new ModelAndView();
		rankList.addObject("gameList", gameList);
		rankList.addObject("page", page);
		rankList.addObject("start", start);
		rankList.addObject("end", end);
		rankList.addObject("max", max);
		rankList.addObject("limitStart", limitStart);
		rankList.addObject("pageList", pageList);
		rankList.setViewName("/ranking/list");
		return rankList;
	}

}
