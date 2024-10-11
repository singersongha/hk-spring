package com.naver.kiosk.kiosk;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kiosks")
@RestController
public class KioskController {

    private final KioskService kioskService;
    public KioskController(KioskService kioskService) {
        this.kioskService = kioskService;
    }

    @GetMapping
    public List<KioskResponse> getAllKiosks() {
        return kioskService.getAllKiosks();
    }

    @GetMapping("/{id}")
    public Kiosk getKioskById(@PathVariable int id ) {
        return kioskService.getKioskById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kiosk createKiosk(@RequestBody KioskRequest request) {
        return kioskService.addKiosk(request);
    }

    @DeleteMapping("/{id}")
    public void deleteKiosk(@PathVariable int id) {
        kioskService.deleteKiosk(id);
    }
}
