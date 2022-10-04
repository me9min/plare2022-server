package org.amel.plare.store.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StoreMenuPageVO {
    
    private int page;

    private int itemsperpage = 5;

    private List<StoreMenuVO> content = new ArrayList<StoreMenuVO>();

    private StoreMenuPageVO prevPage;

    private StoreMenuPageVO nextPage;

    private final int maxPage = (content.size() /itemsperpage) <= 0 ? 1 : content.size() /itemsperpage;

    public StoreMenuPageVO(List<StoreMenuVO> content, int page, StoreMenuPageVO prevPage, StoreMenuPageVO nextPage, int itemsperpage){
        this.content = content;
        this.page = page;
        this.nextPage = nextPage;
        this.prevPage = prevPage;
        this.itemsperpage = itemsperpage == 0 ? 5 : itemsperpage;
    }

    // public setNextpage(StoreMenuPageVO nextPage) {
    //     this.nextPage = nextPage;
    // }
}
