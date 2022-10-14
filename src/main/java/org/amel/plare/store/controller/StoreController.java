package org.amel.plare.store.controller;

import java.util.List;

import org.amel.plare.store.domain.StoreMenuVO;
import org.amel.plare.store.service.StoreMenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {
	StoreMenuService storeMenuService;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ResponseEntity<List<StoreMenuVO>> ItemView(@RequestParam(name = "typeid") int typeId, @RequestParam int size,
			@RequestParam int page) {
		StoreMenuVO storeMenuVO = new StoreMenuVO();
		storeMenuVO.setSize(size);
		storeMenuVO.setPage(page);
		storeMenuVO.setTypeId(typeId);

		return new ResponseEntity<>(storeMenuService.listStoreMenu(storeMenuVO), HttpStatus.OK);
	}
}
