package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;
import com.naver.kiosk.store.StoreRequest;

public record KioskRequest(int kioskNumber, Store store) {

    public Kiosk toKiosk() {
        return new Kiosk(kioskNumber, store);
    }
}
