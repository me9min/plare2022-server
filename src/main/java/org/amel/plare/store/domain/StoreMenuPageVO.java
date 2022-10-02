package org.amel.plare.store.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StoreMenuPageVO {
    public static final StoreMenuPageVO DEFAULT = new StoreMenuPageVO();
    private int page;

    private int itemsperpage;

    private List<StoreMenuVO> content;

    private final int maxPage = (content.size() /itemsperpage) <= 0 ? 1 : content.size() /itemsperpage;

    private StoreMenuPageVO() {
        this. page = 1 ;
        this.itemsperpage = 6;
        content = new ArrayList<>();
    }
    public StoreMenuPageVO(StoreMenuPageVO other, int newItemsperpage) {
        this.page = other.page;
        this.itemsperpage = newItemsperpage;
        this.content = other.content;
    }

    public StoreMenuPageVO(StoreMenuPageVO other, int newPage, List<StoreMenuVO> newContent) {
        this.page = newPage;
        this.itemsperpage = other.itemsperpage;
        this.content = newContent;
    }

}
