package org.amel.plare.shop;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShopMapper {
    @Select("SELECT * FROM shop_menu")
    Shop findByName(@Param("shop") String shop);
}
