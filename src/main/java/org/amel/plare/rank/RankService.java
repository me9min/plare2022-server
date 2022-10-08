package org.amel.plare.rank;

import java.util.List;

import org.amel.plare.rank.domain.GamePlayerVO;

public interface RankService {
	
	public List<GamePlayerVO> selectCredits(int limitStart, int page);
	
	public int pageCount();
	
	
	
}
