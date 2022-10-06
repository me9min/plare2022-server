package org.amel.plare.rank;

import java.util.List;
import org.amel.plare.vo.GamePlayerVO;

public interface RankService {
	
	public List<GamePlayerVO> selectCredits(int page);
	
	public int pageCount();
	
	
	
}
