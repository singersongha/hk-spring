package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;
import com.naver.kiosk.store.StoreRequest;

public record KioskRequest(int storeId) {

    public Kiosk toKiosk() {
        return new Kiosk(storeId);
    }
}
