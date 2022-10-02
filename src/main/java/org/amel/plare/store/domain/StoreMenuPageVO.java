package org.amel.plare.store.domain;

import lombok.Data;

import java.util.List;

@Data
public class StoreMenuPageVO {

    private int maxPage;

    private int page;

    private int itemsperpage = 6;

    private List<StoreMenuVO> content;

}
