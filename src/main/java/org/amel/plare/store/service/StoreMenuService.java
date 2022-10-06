package org.amel.plare.store.service;

import java.util.List;

import org.amel.plare.store.dao.StoreMenuDao;
import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.utils.GroupTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** service and logic class of store
 * 스토어 클래스의 서비스/로직 클래스
 */
@Service
public class StoreMenuService {

    /** data manager class
     *  db class
     */
    final
    StoreMenuDao storeMenuDao;

    /** constructor for storeMenuService class
     * 스토어 서비스 클래스 생성자
     * @param storeMenuDao - db to connect to / 연결된 db(데이터) 관리 클래스
     */
    @Autowired
    public StoreMenuService(StoreMenuDao storeMenuDao) {
        this.storeMenuDao = storeMenuDao;
    }

    /** add item to store
     * 스토어에 아이템 추가
     * @param storeMenu -> item to add/  추가되는 아이템
     * @return number of items being added / 추가되는 아이템의 총 개수
     */
    public int insertStoreMenu(StoreMenuVO storeMenu) {
	    
	    return storeMenuDao.insertStoreMenu(storeMenu);
	}

    /** lists all items in the store_menu
     * 스토어 메뉴의 모든 아이템 리턴
     * @return a List of all items in the Store_menu db
     */
    public List<StoreMenuVO> listStoreMenu() {
        return storeMenuDao.listStoreMenu();
    }

    public List<StoreMenuVO> categoryView(String categoryName, int pageid, int noOfItems) {
        return storeMenuDao.categoryView(GroupTypes.valueOf(Integer.valueOf(categoryName)), pageid, noOfItems);
    }
}
