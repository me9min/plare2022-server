package org.amel.plare.store.utils;

import java.util.HashMap;
import java.util.Map;

public enum GroupTypes {

    ALL(1),
    BASEITEM(2),
    EVENTITEMS(3);

    private int value;
    private static Map<Integer, GroupTypes> securityMap = new HashMap<>();

    private GroupTypes(int value) {
        this.value = value;
    }

    static {
        for (GroupTypes pageType : GroupTypes.values()) {
            securityMap.put(pageType.value, pageType);
        }
    }

    public static GroupTypes valueOf(int unparsedPage) {
        return securityMap.get(unparsedPage);
    }

    public int getValue() {
        return value;
    }
}
