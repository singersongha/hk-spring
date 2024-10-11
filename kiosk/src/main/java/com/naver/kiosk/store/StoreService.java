package com.naver.kiosk.store;

import java.util.List;


public interface StoreService {

    List<StoreResponse> getAllStores();
    Store getStoreById(int id);
    Store addStore(StoreRequest request);
    Store updateStore(StoreRequest request, int id);
    void deleteStore(int id);
}
