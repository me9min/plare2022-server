package org.amel.plare.store.buy.domain;

import java.util.List;

import lombok.Data;

@Data
public class StoreBuyVO {
    
    private int playerId;
    
    private int totalPrice;
    
    private List<StoreBuyMenuVO> storeBuyMenu;
}