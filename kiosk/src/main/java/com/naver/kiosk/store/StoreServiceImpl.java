package com.naver.kiosk.store;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// controller 유저와 개발자의 소통 공간
// service 개발자의 생각 공간
// repository 개발자와 data와의 소통 공간


@Service
public class StoreServiceImpl implements StoreService {
    public List<Store> getAllStores() {
        return Utils.stores;
    }
    public Store getStoreById(int id) {
        return Utils.stores
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StoreNotFoundException(id));
    }
    public Store addStore(StoreRequest request) {
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }

    public void deleteStore(int id){
        Store storeById = getStoreById(id);
        Utils.stores.remove(storeById);
    }

    public Store updateStore(StoreRequest request, int id) {
        return getStoreById(id).update(request);
    }
}
