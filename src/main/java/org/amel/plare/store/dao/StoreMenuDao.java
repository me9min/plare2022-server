package org.amel.plare.store.dao;

import java.util.HashMap;
import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
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

    private int prevSize = 5;
    private String dbName = "store.store_menu";
    private String categoryName = "ALL";

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


    /** lists all items within Store, wrt paging
     * 스토어 내부 페이지 전부 리스팅
     * @return list of all items within store / 스토어 내부 모든 아이템
     */
    private List<StoreMenuVO> changePage(int newPageId, String dbName) {
        String lowerLimit = String.valueOf((newPageId-1) * prevSize+1);
        String upperLimit = String.valueOf(newPageId * prevSize);
        HashMap<String, String> map = new HashMap<>();
        map.put("lowerLimit", lowerLimit);
        map.put("upperLimit", upperLimit);
        map.put("dbName", dbName);

        List<StoreMenuVO> newContent = sqlSession.selectList("storeMenu.selectPageList", map);

        return newContent;
    }

    private List<StoreMenuVO> listStoreMenuByPage(int pageid, int noOfItems, String dbName) {
        if(noOfItems == prevSize) return changePage(pageid, dbName);

        this.prevSize = noOfItems;

        String prevPagelowerLimit = String.valueOf(1);
        String upperLimit = String.valueOf((noOfItems));

        HashMap<String, String> map = new HashMap<>();
        map.put("lowerLimit", prevPagelowerLimit);
        map.put("upperLimit", upperLimit);
        map.put("dbName", dbName);

        List<StoreMenuVO> newContent = sqlSession.selectList("storeMenu.selectPageList", map);

        return newContent;
    }

    public List<StoreMenuVO> categoryView(String categoryName, int pageid, int noOfItems) {
        if(!categoryName.equals(this.categoryName)){
            if(categoryName != "ALL") {
                sqlSession.insert("TempTableCreate"); //ACCESS DENIED TO STORE -> GIVE PRIVILEGE FFS
                sqlSession.insert("TempTableInit", categoryName);
                // sqlSession.selectList("storeMenu.createCategoryTable", categoryName);
                dbName = "TempCategoryList";
            } else {
                dbName = "store.store_menu";
            }
        }

        this.categoryName = categoryName;
        return listStoreMenuByPage(pageid, noOfItems, dbName);
    }
}
