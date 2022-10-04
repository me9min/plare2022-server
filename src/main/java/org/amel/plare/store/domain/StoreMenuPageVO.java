package org.amel.plare.store.domain;

import lombok.Data;
import java.util.List;

@Data
public class StoreMenuPageVO {
    private int page;

    private int itemsperpage = 5;

    private List<StoreMenuVO> content;

    private StoreMenuPageVO prevPage;

    private StoreMenuPageVO nextPage;

    private final int maxPage = (content.size() /itemsperpage) <= 0 ? 1 : content.size() /itemsperpage;
}
