package com.naver.kiosk.store;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Restful API
리소스(data)를 꺼내 주자
endpoint /store
method GET R
       POST C
       PUT, PATCH U body o
       DELETE D body x
전체 스토어를 가져온다.( /stores ) (GET)
스토어에 추가한다. (/stores) (POST)
스토어 중에 id= 1 인거 가져와라. (/stores/1) (GET)
스토어 안에 이름이 커피가 들어간 친구들 뽑아와라. (/stores?name=커피&open-time=10) (GET)
1번 스토어 이름을 커피로 바꾸고 싶다.
(/stores/1, {name="커피", "ㅇㅇ", "ㄴㄴ"}) (PUT)
setName("커피")
나머지 것은 두고 슬쩍 수정 PATCH (패치노트)
[1][2][3] <- [new3]
전에 있던 것을 갈아 치운다 PUT
스토어 1번을 지운다 (stores/1) (DELETE)

정리
1. URL 복수형만 사용해라 (/store)
2. 명사만 사용해라 (/stores/create x)
3. 소문자로 작성해라 (/storesCreate) -> (/stores-create)
4. 언더바(_) 말고 하이픈(-)으로 작성해라

http 통신

status code
100 =< > 200 socket
200 =< >300 http 통신(성공)
300 =< > 400 html을 사용할 때(Found, Redirect)
400 =< > 500 Client 실수 (404 not found, 401 권한 없음)
500 =< > 600 서버 측 실수 (500 internal server error)
*/

@RequestMapping("/stores")
@RestController
public class StoreController {
    private final StoreService storeService;
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
        //this.storeService = new StoreService();
    }

    @GetMapping
    public List<StoreResponse> getAllStores() {
        //localhost:8080
        return storeService.getAllStores();
    }

    // localhost:8080/id 변수 주소
    @GetMapping("/{store-id}")
    public Store getStoreById(@PathVariable(value = "store-id") int id) {
//        Integer id = 10_000;
        return storeService.getStoreById(id);
        // 비어있으면 에러 발생

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store saveStore(
            @RequestBody StoreRequest request
    )
    {
        return storeService.addStore(request);
    }

    @DeleteMapping("/{store-id}")
    public void deleteStore(@PathVariable(value = "store-id") int id) {
        storeService.deleteStore(id);
    }

    @PutMapping("/{store-id}")
    public Store updateStore(@PathVariable(value = "store-id") int id,
                             @RequestBody StoreRequest request) {
        return storeService.updateStore(request, id);
    }

//    public static void main(String[] args) {
//        Store store = new Store("매머드", "서울",(short) 7, (short) 21);
//        Store store2 = new Store("깐부", "서울",(short) 11, (short) 1);
//        Utils.stores.add(store);
//        Utils.stores.add(store2);
//        List<Store> allStores = new StoreController().getAllStores();
//        for(int i = 0; i < allStores.size(); i++) {
//            if(Utils.stores.get(i).equals(allStores.get(i)))
//                throw new RuntimeException();
//        }
//    }
    }
