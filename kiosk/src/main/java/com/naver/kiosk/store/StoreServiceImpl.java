package com.naver.kiosk.store;

import org.springframework.stereotype.Service;

import java.util.List;

// controller 유저와 개발자의 소통 공간
// service 개발자의 생각 공간
// repository 개발자와 data와의 소통 공간


@Service
public class StoreServiceImpl implements StoreService {

    public List<StoreResponse> getAllStores() {

        List<StoreResponse> list = StoreUtils.stores
                .stream()
//                .map((el) -> StoreResponse.from(el)) 람다식으로 변환
                .map(StoreResponse::from)
                .toList();
        return list;
    }
    public Store getStoreById(int id) {

        return StoreUtils.stores
                .stream()
                .filter(el -> el.getId() == id && !el.isDeleted())
                .findFirst()
                .orElseThrow(() -> new StoreNotFoundException(id));
    }
    public Store addStore(StoreRequest request) {
        Store store = request.toStore();
        StoreUtils.stores.add(store);
        return store;
    }

    public void deleteStore(int id){
        Store storeById = getStoreById(id);
        storeById.delete();
    }

    public Store updateStore(StoreRequest request, int id) {
        return getStoreById(id).update(request);
    }
}
