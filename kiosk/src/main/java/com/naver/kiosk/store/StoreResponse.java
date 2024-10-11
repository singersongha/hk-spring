package com.naver.kiosk.store;

public record StoreResponse(String name, String address, short openTime, short closeTime, int id) {

    public static StoreResponse from(Store store){
        // 팩토리 메소드
        return new StoreResponse(
                store.getName(), store.getAddress(), store.getOpenTime(),
                store.getCloseTime(), store.getId());
    }
}
