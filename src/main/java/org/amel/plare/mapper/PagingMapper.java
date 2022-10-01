package org.amel.plare.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PagingMapper {
	int count(PagingMapper params);
}
