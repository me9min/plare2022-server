package org.amel.plare.store.utils;

import java.util.HashMap;
import java.util.Map;

public enum GroupTypes {

    ALL(1),
    BASEITEM(2),
    EVENTITEMS(3);

    private int value;
    private static Map<Integer, GroupTypes> securityMap = new HashMap<>();
    private static Map<Integer, String> DBMap = new HashMap<>();

    private GroupTypes(int value) {
        this.value = value;
    }

    static {
        for (GroupTypes pageType : GroupTypes.values()) {
            securityMap.put(pageType.value, pageType);
            if(pageType.value == 1) { DBMap.put( pageType.value, "store.store_menu");}
            else {DBMap.put ( pageType.value, "plare.TempCategoryList");}
        }
    }

    public static GroupTypes valueOf(int unparsedPage) {
        return securityMap.get(unparsedPage);
    }

    public static String DBvalueOf(int unparsedPage) {
        return DBMap.get(unparsedPage);
    }

    public int getValue() {
        return value;
    }
}
