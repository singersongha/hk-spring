package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;

public class Kiosk {
    public int getId() {
        return id;
    }

    public int getKioskNumber() {
        return kioskNumber;
    }

    public Store getStore() {
        return store;
    }

    public boolean isActive() {
        return active;
    }

    public void delete() {
        active = false;
    }

    private final int id;
    private int kioskNumber;
    private Store store;
    private boolean active;

    public Kiosk(int kioskNumber, Store store) {
        this.id = Utils.kioskCount++;
        this.kioskNumber = kioskNumber;
        this.store = store;
        this.active = true;
    }
}
