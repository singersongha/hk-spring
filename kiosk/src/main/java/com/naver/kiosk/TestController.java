package com.naver.kiosk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
    fw react, vue, next, nuxt
    react -> 통신 요청 -> spring data(json) 받아감
    mvc
    @controller view 꺼내준다
    @RestController = @Controller + @ResponseBody
 */
@RestController
//@ResponseBody
public class TestController {
    //localhost:8080/java
    // 10초 걸림
//    @RequestMapping( value = "/java", method = RequestMethod.GET)
    @GetMapping("/java")
    public String java() {
        return "java";
    }
    // get 메소드로 /name으로 이름 출력하는 것 만들기
    // API application programming interface(접점)
    // endpoint /name
    @GetMapping("/name")
    public String name() {
        return "김송하";
    }
}
