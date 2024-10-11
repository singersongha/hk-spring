package com.naver.kiosk.kiosk;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KioskService {

    // 모든 kiosk 조회
    public List<KioskResponse> getAllKiosks() {

        List<KioskResponse> list = KioskUtils.kiosks
                .stream()
                .map(KioskResponse::from)
                .toList();
        return list;

    }

    // id로 kiosk 조회
    public Kiosk getKioskById(int id) {

        return KioskUtils.kiosks
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Kiosk not found"));
    }

    // kiosk 추가
    public Kiosk addKiosk(KioskRequest request) {
        Kiosk kiosk = request.toKiosk();
        KioskUtils.kiosks.add(kiosk);
        return kiosk;
    }


    // kiosk 삭제
    public void deleteKiosk(int id) {
        Kiosk kioskById = getKioskById(id);
        KioskUtils.kiosks.remove(kioskById);
    }
}
