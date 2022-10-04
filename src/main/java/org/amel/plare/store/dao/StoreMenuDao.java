package org.amel.plare.store.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.amel.plare.store.domain.StoreMenuPageVO;
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

    private StoreMenuPageVO prevPage;

    /** constructor class for Store DAO
     *  Store DAO 의 생성자
     * @param sqlSession 링크된 sql 세션
     */
    @Autowired
    public StoreMenuDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.prevPage = new StoreMenuPageVO(new ArrayList<StoreMenuVO>(), 1, null, null, 5);
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
    public List<StoreMenuVO> listStoreMenuByPage(int newPageId) {
        
        int lowerLimit = (newPageId-1) * prevPage.getItemsperpage()+1;
        int upperLimit = newPageId * prevPage.getItemsperpage();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("lowerLimit", lowerLimit);
        map.put("upperLimit", upperLimit);

        List<StoreMenuVO> newContent = sqlSession.selectList("storeMenu.selectPageList", map);
        
        StoreMenuPageVO currPage = new StoreMenuPageVO(newContent, newPageId, prevPage, null, prevPage.getItemsperpage());
        this.prevPage.setNextPage(currPage);
        this.prevPage = currPage;

        return newContent;
    }

    public List<StoreMenuVO> changeNoOfDisplayedItems(int pageid, int noOfItems) {
        if(noOfItems == prevPage.getItemsperpage()) return listStoreMenuByPage(pageid);
        
        int prevPageId = prevPage.getPage();
        int prevPagelowerLimit = (prevPageId-1) * prevPage.getItemsperpage() + 1;
        int upperLimit = prevPagelowerLimit + noOfItems - 1;

        HashMap<String, Integer> map = new HashMap<>();
        map.put("lowerLimit", prevPagelowerLimit);
        map.put("upperLimit", upperLimit);

        List<StoreMenuVO> newContent = sqlSession.selectList("storeMenu.selectPageList", map);

        int newPageId = upperLimit/noOfItems;

        StoreMenuPageVO currPage = new StoreMenuPageVO(newContent, newPageId, prevPage, null, noOfItems);
        this.prevPage.setNextPage(currPage);
        this.prevPage = currPage;

        return newContent;
    }
}
