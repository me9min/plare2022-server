package org.amel.plare.rank;

import java.util.List;

import org.amel.plare.mapper.RankMapper;
import org.amel.plare.vo.GamePlayerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service("rankServiceTest")
public class RankServiceImpl implements RankService{
	
	@Autowired
	private RankMapper rankMapper;
	
	@Override
	public List<GamePlayerVO> selectCredits(){
		
		
		List<GamePlayerVO> gameList = rankMapper.selectCredits();
		
		return gameList;
	}
	
	
	
}
