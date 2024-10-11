package com.naver.kiosk.store;

import ch.qos.logback.core.util.StringUtil;

// 1. 가게
// name : 매머드커피
// address : 서울
// opentime : 7
// closetime : 21
// id : 1
// 2. 가게
// name : 깐부치킨
// address: 서울
// opentime : 11
// closetime : 1
// id : 2
public class Store {

    public Store(String name, String address, short openTime, short closeTime) {
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.id = StoreUtils.storeCount++;
        this.isDeleted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public short getOpenTime() {
        return openTime;
    }

    public short getCloseTime() {
        return closeTime;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    private String name;
    private String address;
    private short openTime;
    private short closeTime;
    private final int id;
    private boolean isDeleted;
    private int kioskCount = 1;

    public int getKioskCount() {
        return kioskCount;
    }

    public int kioskCountIncrease() {
        return kioskCount++;
    }



    public void delete() {
        isDeleted = true;
    }

    public Store update(StoreRequest request){
        if(!StringUtil.isNullOrEmpty(request.name()))
            this.name = request.name();
        if(!request.address().isEmpty())
            this.address = request.address();
        return this;
    }
}
