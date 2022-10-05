package org.amel.plare.store.utils;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMapper {

    List<StoreMenuVO> selectPageList(@Param("lowerLimit") String lowerLimit, @Param("upperLimit") String upperLimit, @Param("dbName") String dbName);

}
