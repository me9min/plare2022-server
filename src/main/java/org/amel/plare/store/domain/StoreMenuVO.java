package org.amel.plare.store.domain;

import lombok.Data;

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
}
