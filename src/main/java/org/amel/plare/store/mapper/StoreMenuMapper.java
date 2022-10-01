package org.amel.plare.store.mapper;

import org.amel.plare.store.domain.StoreMenuVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMenuMapper {
	
	public int insertStoreMenu(StoreMenuVO storeMenu);
}
