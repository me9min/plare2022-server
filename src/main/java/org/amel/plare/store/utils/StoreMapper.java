package org.amel.plare.store.utils;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMapper {

    List<StoreMenuVO> selectPageList(@Param("lowerLimit") int lowerLimit, @Param("upperLimit") int upperLimit);
    
}
