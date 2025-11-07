package com.sourjelly.springexample.lifecycle;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lifecycle/ex01")
@RestController // @Controller + @ResponseBody
public class Ex01RestController {

    // 직접 만든 Class 객체 response에 담는 페이지
    @RequestMapping("/3")
    public Person  personResponse(){
        Person me = new Person("오준석", 26);

        return me;
    }

    // Status code를 수정한 response 만들기
    @RequestMapping("/4")
    public ResponseEntity<Person> statusResponse(){

        Person me = new Person("오준석", 26);

        ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);

        return entity;

    }

}
