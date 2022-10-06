package org.amel.plare.store.dao;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    private int prevSize = 5;
    private String dbName = "store.store_menu";
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

    /** lists all items within Store, wrt paging
     * 스토어 내부 페이지 전부 리스팅
     * @return list of all items within store / 스토어 내부 모든 아이템
     */
    private List<StoreMenuVO> changePage(int newPageId, String dbName) {
        String lowerLimit = String.valueOf((newPageId-1) * prevSize+1);
        String upperLimit = String.valueOf(newPageId * prevSize);
        return getStoreMenuVOS(dbName, lowerLimit, upperLimit);
    }

    private List<StoreMenuVO> listStoreMenuByPage(int pageid, int noOfItems, String dbName) {
        if(noOfItems == prevSize) return changePage(pageid, dbName);

        this.prevSize = noOfItems;

        String prevPagelowerLimit = String.valueOf(1);
        String upperLimit = String.valueOf((noOfItems));

        return getStoreMenuVOS(dbName, prevPagelowerLimit, upperLimit);
    }

    private List<StoreMenuVO> getStoreMenuVOS(String dbName, String prevPagelowerLimit, String upperLimit) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lowerLimit", prevPagelowerLimit);
        map.put("upperLimit", upperLimit);
        map.put("dbName", dbName);

        List<StoreMenuVO> newContent = sqlSession.selectList("storeMenu.selectPageList", map);

        return newContent;
    }

    public List<StoreMenuVO> categoryView(GroupTypes categoryName, int pageid, int noOfItems) {
        System.out.println(categoryName);
        if(!categoryName.equals(this.categoryName)){
            if(!categoryName.equals(GroupTypes.ALL)) {
                sqlSession.insert("TempTableCreate", categoryName.getValue());

                dbName = "plare.TempCategoryList";
            } else {
                dbName = "store.store_menu";
            }
        }

        this.categoryName = categoryName;
        return listStoreMenuByPage(pageid, noOfItems, dbName);
    }
}
