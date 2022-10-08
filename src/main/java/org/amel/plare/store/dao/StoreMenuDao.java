package org.amel.plare.store.dao;

import java.util.HashMap;
import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.utils.GroupTypes;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** repository class(data-manager) of store class
 *  store 클래스의 레포 클래스
 */
@Repository
public class StoreMenuDao {

    /** linked sql session to the data manager
     *  링크된 sql 세션
     */
    final
    SqlSession sqlSession;

    /** 이전 페이지에 쓰이던 페이지당 아이템 개수
     * 디폴트값 = 5;
     */
    private int prevSize = 5;
    /** 이전 페이지에 엑세스한 DB 이름
     * 디폴트값 = "store.store_menu";
     */
    private String dbName = "store.store_menu";
    /** 이전 페이지에서 쓰이던 쿼리 종류
     * 디폴트값: ALL
     */
    private GroupTypes categoryName = GroupTypes.ALL;

    /** constructor class for Store DAO
     *  Store DAO 의 생성자
     * @param sqlSession 링크된 sql 세션
     */
    @Autowired
    public StoreMenuDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /** method to add item into the store menu
     * 스토어에 아이템 추가
     * @param storeMenu 아이템 클래스(도메인) ShopMenu API class
     * @return total number of added items / 추가된 아이템 개수
     */
    public int insertStoreMenu(StoreMenuVO storeMenu) {
        
        return sqlSession.insert("storeMenu.insert", storeMenu);
    }

    /** lists all items within the Store
     * 스토어 내부 아이템 전부 리스팅
     * @return list of all items within store / 스토어 내부 모든 아이템
     */
    public List<StoreMenuVO> listStoreMenu() {
        return sqlSession.selectList("storeMenu.selectList");
    }

    /** 페이지 변경용 메서드
     *  changes page
     * @param newPageId 새로 갈 페이지 번호
     * @param dbName 액세스할 DB 이름
     * @return 새로 갈 페이지 번호에 존재하는 아이템 json
     */
    private List<StoreMenuVO> changePage(int newPageId, String dbName) {
        String lowerLimit = String.valueOf((newPageId-1) * prevSize+1);
        String upperLimit = String.valueOf(newPageId * prevSize);
        return getStoreMenuVOS(dbName, lowerLimit, upperLimit);
    }

    /** changes number of items per page
     * 페이지당 아이템 개수 초기화 -> 페이지는 1로 바뀜
     * @param noOfItems 1 페이지당 아이템 개수 
     * @param dbName 엑세스할 DB 이름
     * @return 페이지당 아이템 개수에 맞는 json
     */
    private List<StoreMenuVO> changeItemsPerPage(int noOfItems, String dbName){
        
        this.prevSize = noOfItems;

        String prevPagelowerLimit = String.valueOf(1);
        String upperLimit = String.valueOf((noOfItems));

        return getStoreMenuVOS(dbName, prevPagelowerLimit, upperLimit);
    }

    /** 페이지 포매팅 메스드. 페이징 메서드랑 페이지당 아이템 개수 변경 메서드 포함
     * page formatting method
     * @param pageid 새로 갈 페이지
     * @param noOfItems 페이지당 아이템 개수
     * @param dbName 엑세스할 DB 이름
     * @return 포맷팅된 페이지에 맞는 sql 쿼리
     */
    private List<StoreMenuVO> listStoreMenuByPage(int pageid, int noOfItems, String dbName) {
        if(noOfItems == prevSize) {
            return changePage(pageid, dbName);
        } else {
            return changeItemsPerPage(noOfItems, dbName);
        }
    }

    /** creates map and executes sql selectlist operation 
     * sql 셀렉트 쿼리 대신 해주는 메서드 (페이징 및 페이지별 아이템 개수 처리 시 코드중복 리팩토링)
     * @param dbName 액세스할 DB 명
     * @param prevPagelowerLimit 이전 페이지에서 존재하던 가장 낮은 ID
     * @param upperLimit 현재 페이지에서 존재해야 하는 가장 높은 ID
     * @return sql 쿼리.
     */
    private List<StoreMenuVO> getStoreMenuVOS(String dbName, String prevPagelowerLimit, String upperLimit) {
        HashMap<String, String> map = new HashMap<>(); //SQL insert 도움 필요 -> Map 에서 xml 이 런타임 타입 볼 수 있는지 모름
        map.put("lowerLimit", prevPagelowerLimit);
        map.put("upperLimit", upperLimit);
        map.put("dbName", dbName);

        List<StoreMenuVO> newContent = sqlSession.selectList("storeMenu.selectPageList", map);

        return newContent;
    }

     /** provides a json file containing search_items based on URL, paged.
     * 검색된 아이템을 URL 기반으로 리턴
     * @param categoryName 카테고리 이름(이넘) -> 0(ALL) 1(기본아이템), 2(이벤트아이템) -> 추후 변경 가능
     * @param pageid 가고싶은 페이지 번호
     * @param noOfItems 페이지당 아이템 개수
     * 
     * @return list of items in shop / 샵 내부 아이템 리스트
     */
    public List<StoreMenuVO> ItemView(GroupTypes categoryName, int pageid, int noOfItems) {
        System.out.println(categoryName);
        if(!categoryName.equals(this.categoryName)){
            if(!categoryName.equals(GroupTypes.ALL)) {
                sqlSession.insert("TempTableCreate", categoryName.getValue());
            }
            dbName = GroupTypes.DBvalueOf(categoryName.getValue());
        }

        this.categoryName = categoryName;
        return listStoreMenuByPage(pageid, noOfItems, dbName);
    }
}
