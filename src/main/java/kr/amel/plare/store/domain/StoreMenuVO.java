package kr.amel.plare.store.domain;

import lombok.Data;

/** a class showing the items a shop sell
 * 샵 내부 아이템 클래스
 */
@Data
public class StoreMenuVO {
    private int id;

    private int groupId;
    
    private int typeId;

    private int price;

    private String name;

    private String flag;

    private String attributeJson;

    private String description;  
    
    private int page;
    
    private int size;
}
