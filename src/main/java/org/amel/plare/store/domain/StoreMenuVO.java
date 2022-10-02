package org.amel.plare.store.domain;

import lombok.Data;

/** a class showing the items a shop sell
 * 샵 내부 아이템 클래스
 */
@Data
public class StoreMenuVO {

    /** id of item within table
     *  해당 아이템의  sql 테이블 내부 id
     */
    private int id;

    /** paging id
     * 상품 그룹아이디 store_group에서 검색, 같은페이지에 묶는의미
     */
    private int groupId;

    /** category id of item
     *  상품 타입아이디 store_type에서 검색, 실제 아이템 타입
     */
    private int typeId;

    /** item price for items in shop
     * 아이템 가격
     */
    private int price;

    /** item name for items in shop
     * 아이템명 - 아이템 이름
     */
    private String name;

    /** visibility flag for items. if blank, shown to all users, if b, to admin or above
     *  빈칸이면 모두에게 노출되며 b 일시 관리자에게만 노출됨
     */
    private String flag;

    /** json that is used to communicate with the game-server(ignore)
     *  게임서버에서만 사용하는 속성 json형식으로 저장, 무시
     */
    private String attributeJson;

    /** item description
     * 아이템 설명
     */
    private String description;
}
