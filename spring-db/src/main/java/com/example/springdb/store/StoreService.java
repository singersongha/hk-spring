package com.example.springdb.store;

import java.util.List;

public interface StoreService {
// post api/v1/stores
    Store save(Store store);
// put api/v1/stores/{id}
    Store update(Long id, Store store);
// GET api/v1/stores/{id}
    Store getById(Long id);
//  GET api/v1/stores?name=?
    List<Store> getByContainName(String name);
// GET api/v1/stores
    List<Store> getAll();
// DELETE api/v1/stores/{id}
    void deleteById(Long id);
    void deleteByNameContain(String name);




}
