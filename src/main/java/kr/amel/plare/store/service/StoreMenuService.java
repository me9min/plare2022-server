package kr.amel.plare.store.service;

import java.util.List;

import kr.amel.plare.store.dao.StoreMenuDao;
import kr.amel.plare.store.domain.StoreMenuVO;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StoreMenuService {
	StoreMenuDao storeMenuDao;

	public List<StoreMenuVO> listStoreMenu(StoreMenuVO storeMenuVO) {
		int size = storeMenuVO.getSize();
		int page = (storeMenuVO.getPage()-1) *size;
		
		storeMenuVO.setPage(page);
		
		return storeMenuDao.listStoreMenu(storeMenuVO);
	}
}
