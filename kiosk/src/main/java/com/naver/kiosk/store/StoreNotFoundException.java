package com.naver.kiosk.store;

public class StoreNotFoundException extends IllegalArgumentException {
    public StoreNotFoundException(int id) {
        super(id + "IS NOT FOUND");
    }
}
