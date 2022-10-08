package org.amel.plare.mapper;

import java.util.List;

import org.amel.plare.rank.domain.GamePlayerVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RankMapper {
	List<GamePlayerVO> selectCredits(int limitStart, int page);

	int pageCount();
}
