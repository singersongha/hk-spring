package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @annotation
// request 유저가 요청 하는 것
// response 우리가 유저한테 주는 것
// 내 컴퓨터에 http 통신 접근할 수 있게 도와주는 것 web server
// 내 컴퓨터에 http 통신 접근할 수 있게 해주고 코드를 돌리는 것 web application server(was)
// spring framework vs spring boot
//     main (x)     |     main(o)
//     java 실행 x   |
// spring framework web을 만들면 java x tomcat 실행
//    설정할게 많음   |
// server를 통해 html 그려줌(render) - server side render(ssr)
// ssr - java -> spring @controller -> @requestmapping("/") -> 메서드 실행 -> index.html
// /-> /test

// single page application(spa) - index.html -> js -> /register -> Resister.jsx (client side render)
// /-> /register
// index.html, js, css  -> js 보니까 -> / -> Boards.jsx  를 보여주세요
// -> js 보니까 -> /register -> Register.jsx 를 보여주세요

// ssr vs csr : 시작점이 다름/ csr은 html을 한 번 가져옴, 초기 로딩이 길다 그 후 로딩 짧다, 검색엔진 노출이 힘들다, js가 뭉쳐있음, 반응형이라 유저 사용감이 좋다.
// ssr은 n번 가져옴, 초기 로딩이 짧다 그 후 로딩 길다, 검색엔진 노출이 좋다, js가 쪼개져 있음, 계속 페이지가 새로고침되어 사용감이 안좋음.
// ssr 단점 해결 -> next.js

@Controller
public class TestController {
    @RequestMapping
    public String index(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        return "index";
    }
    // localhost:8080/java
    @RequestMapping(value = "/java", method = RequestMethod.GET)
    public String java() {
        return "java";
    }
    //localhost:8080/test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
