package org.amel.plare.store.utils;

import java.util.HashMap;
import java.util.Map;

/** sql에 존재하는 아이템 카테고리를 나타내는 enum
 * 인젝션 공격에 대응하기 위하여 만들어졌다
 */
public enum GroupTypes {
    /**
     * 아이템 카테고리별 이넘 매핑
     */
    INVALID(-1),
    ALL(0),
    BASEITEM(1),
    EVENTITEMS(2);

    /**
     * 이넘에 매핑당하는 정수값
     */
    private int value;
    /**
     * 이넘 할당 정수값 : 이넘값 매핑 ( 추후 액세스하는 메서드에서 사용 )
     */
    private static Map<Integer, GroupTypes> securityMap = new HashMap<>();
    /**
     * 이넘 할당 정수값 : 액세스할 DB 값 매핑
     */
    private static Map<Integer, String> DBMap = new HashMap<>();

    /**
     * 생성자 메서드. 이넘 : 정수 매핑된 형태로 이넘을 생성
     * @param value 새 이넘을 매핑할 정수값
     */
    private GroupTypes(int value) {
        this.value = value;
    }

    /**
     * 이넘 파일 로드 시 자동으로 돌아가는 스태틱 블록.
     * securityMap 및 DBMap에 현 클래스 로드 시 현재 존재하는 이넘값들을 알맞게
     * 매핑해서 넣어줌
     */
    static {
        for (GroupTypes pageType : GroupTypes.values()) {
            securityMap.put(pageType.value, pageType);
            if(pageType.value == 1) { DBMap.put( pageType.value, "store.store_menu");}
            else {DBMap.put ( pageType.value, "plare.TempCategoryList");}
        }
    }

  /**
   * 정수값을 받고 매핑된 이넘값을 리턴
   * @param unparsedItemCat URL 에서 다이렉트로 받은 아이템 카테고리값
   * @return 해당 아이템 카테고리값이랑 매핑된 이넘값
   * @throws IllegalArgumentException -> 카테고리 미존재
   */
    public static GroupTypes valueOf(int unparsedItemCat) throws IllegalArgumentException {
        GroupTypes res = securityMap.getOrDefault(unparsedItemCat, GroupTypes.INVALID);
        if(res.equals(GroupTypes.INVALID)) {
            throw new IllegalArgumentException("such a item category is not present");
        }
        return res;
    }

    /**
     * 정수값을 받고 매핑된 DB 스트링을 리턴
     * @param unparsedItemCat URL 에서 다이렉트로 받은 아이템 카테고리값
     * @return 해당 아이템 카테고리값이랑 매핑된 디비 스트링 값
     */
    public static String DBvalueOf(int unparsedItemCat) {
        return DBMap.get(unparsedItemCat);
    }

    /**
     * 현 이넘의 매핑된 정수값을 리턴해줌
     * @return 현 이넘에 매핑된 정수값
     */
    public int getValue() {
        return value;
    }
}
