package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;
import com.naver.kiosk.store.StoreUtils;

public class Kiosk {
    public int getId() {
        return id;
    }

    public int getKioskNumber() {
        return kioskNumber;
    }

    public Store getStore(int id) {
        return StoreUtils.stores
                .stream()
                .filter((el) -> el.getId() == id && !el.isDeleted())
                .findFirst()
                .orElseThrow(() -> new RuntimeException(id + " is not found"));

    }

    public boolean isActive() {
        return active;
    }

//    public void delete() {
//        active = false;
//    }

    public int getStoreId() {
        return storeId;
    }

    private final int id;
    private Store store;
    private boolean active;
    private int storeId;
    private int kioskNumber;

    public Kiosk(int storeId) {
        this.id = KioskUtils.kioskCount++;
        this.store = getStore(storeId);
        this.active = true;
        this.storeId = storeId;
        this.kioskNumber = store.kioskCountIncrease();
    }
}
