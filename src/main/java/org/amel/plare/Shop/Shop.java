package org.amel.plare.Shop;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/** a shop class to represent a Shop and the items it sell
 * 아이템 품목/가격 등을 보여주는 샵 클래스
 */
@Data
public class Shop {

    /** unique id for items in the shop
     *  uid라고 읽고 파일명이라 쓰는 아이템 uid
     */
    private String uid;

    /** item type for items in shop
     * 아이템타입 - 아이템이 무슨 종류인지 보여준다
     */
    private String item_type;

    /** item name for items in shop
     * 아이템명 - 아이템 이름
     */
    private String item_name;

    /** item price for items in shop
     * 아이템 가격
     */
    private int item_price;

    /** item count for items in shop {tentatively disabled default = -1}
     * 아이템 개수{비활성화되있는거 같다}
     */
    private int item_count;

    /** a descriptor for events categories of items
     * 아이템 카테고리 라고 쓰고 어떤 이벤트/제휴되있는지 설명
     */
    private String item_cat;

    /** relative link for item image files
     *  아이템 이미 파일 링크
     */
    private String item_img;

    /** item descriptor to be shown to users
     *  아이템 설명(충)
     */
    private String item_Dec;

}
