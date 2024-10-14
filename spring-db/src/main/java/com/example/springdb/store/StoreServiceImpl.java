package com.example.springdb.store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
// -> 필수적인 것만 자동적으로 생성
//@AllArgsConstructor
public class StoreServiceImpl implements StoreService {
//required argument
    private final StoreRepository storeRepository;
//    public StoreServiceImpl(StoreRepository storeRepository) {
//        this.storeRepository = storeRepository;
//    } -> @AllArgsConstructor
    @Override
    public Store save(Store store) {

//        Store store1 =
//                new Store(null, "name", "addr");
        return storeRepository.save(store); // insert
//        log.info("store1 id : {}", store1.getId()); // id : null
    }

    @Override
    @Transactional // 에러 rollback return commit - dirty checking
    public Store update(Long id, Store store) {
        Store store1 = getById(id);
        store1.setAddress(store.getAddress());
        store1.setName(store.getName());
//        storeRepository.save(store1); // insert, update
        return store1;
    }

    @Override
    public Store getById(Long id) {
        // select * from tbl where id = ?
        return storeRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Store> getByContainName(String name) {
        return storeRepository.findByNameContain(name);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public void deleteByNameContain(String name) {
        storeRepository.deleteByNameContain(name);
    }


    static int i = 0;

    /*    엔티티 매니저에서 찾아온 값을 등록 해놓고 그것을 조회해서 없다면 실제 db에서 찾는다.
      있으면 엔티티 매니저가 바로 리턴해준다.즉, db의 부하를 줄일 수 있다.
      엔티티 매니저의 생명주기는 트랜잭션이 맺어지고 소멸까지이다.
      jpa 왜 쓰나요? entity manager를 통해 db 부하를 줄일 수 있다.
    */

//    @Override
//    public void update(Store store) {
//
//        Store store1 =
//                new Store(1L, "update"+ i++, "update");
//        storeRepository.save(store1); // save : insert 와 update 같이 해줌
////      아이디 있는지 찾아보고 있으면 update를 해주고 없으면 insert 해줌
//    }
}


/*
mySql {store - st}
Jpa {Entity manager}
java save(sts) 메소드 사용 -> 엔티티 매니저에서 찾음 -> 없으면 db에서 찾음 -> st != sts 이므로 바뀐 것 같다고 update 날림
 */