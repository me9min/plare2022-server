package org.amel.plare.page;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    private static int maxPage;

    private int page;

    private List<T> content;

}
