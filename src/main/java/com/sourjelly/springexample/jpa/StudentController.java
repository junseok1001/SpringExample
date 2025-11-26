package com.sourjelly.springexample.jpa;

import com.sourjelly.springexample.jpa.domain.Student;
import com.sourjelly.springexample.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/lombok")
    public Student lombokTest(){
//        Student student = new Student(
//                1
//                , "오준석"
//                , "010-1111-2222"
//                , "123456789.com"
//                , "개발자"
//                , LocalDateTime.now()
//                , LocalDateTime.now());

        // builder 패턴을 통한 객체 생성
        Student student = Student.builder()
                .name("김인규")
                .phoneNumber("010-1111-2222")
                .dreamJob("개발자")
                .build();

        return student;
    }

    @GetMapping("/add")
    @ResponseBody
    public Student addStudent(){
        // 학생에 대한 정보
        // 김인규, 010-1111-2222, lecture@hagulu.com, 개발자
        Student student = studentService.createStudent("김인규", "010-1111-2222", "lecture@hagulu.com", "개발자");

        return student;
    }

    @GetMapping("/modify")
    @ResponseBody
    public Student modifyStudent(){
        // id가 3인 학생의 장례희망을 강사로 변경

        Student student = studentService.updateStudent(3,"강사");

        return student;

    }

    @GetMapping("/remove")
    @ResponseBody
    public String removeStudent(){
        // id 가 3인 학생 삭제
        studentService.deleteStudent(3);

        return "삭제 완료";
    }
}
