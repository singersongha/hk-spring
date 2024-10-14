package com.example.springdb.store;

import ch.qos.logback.core.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// front back domain
// naver.com/stores front
// naver.com/api/v1/stores back
// web 다운로드를 x
// app(update x) code update x
// api/v1/stores
@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public void saveStore(@RequestBody Store store) {
        storeService.save(store);
    }

    @PutMapping("{id}")
    public void updateStore(@PathVariable Long id, @RequestBody Store store) {
        storeService.update(id, store);
    }

    @GetMapping
//    stores?name=fdsd
    public List<Store> getAllStores(
            @RequestParam(
                    required = false,
                    name = "name"
            ) String name) {
        if(!StringUtil.isNullOrEmpty(name)) return null;
        return storeService.getAll();
    }
    @GetMapping("{id}")
    public Store getById(@PathVariable Long id){
        return storeService.getById(id);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        storeService.deleteById(id);
    }
}
