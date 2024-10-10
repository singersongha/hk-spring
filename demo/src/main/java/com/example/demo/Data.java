package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 클래스 위에 @component로 list 생성해서 bean으로 관리한다.

@Component
public class Data {
    public List<Student> list;

    public Data(Student 이세연) {
        this.list = new ArrayList<>();
        list.add(이세연);

    }
}
