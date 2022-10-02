package org.amel.plare.store.domain;

import java.util.List;

import lombok.Data;

@Data
public class StoreMenuPageVO {
    
    private List<StoreMenuVO> content;
    
    private int page;
}
