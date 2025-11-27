package com.sourjelly.springexample.jpa;

import com.sourjelly.springexample.jpa.domain.Student;
import com.sourjelly.springexample.jpa.repository.StudentRepository;
import com.sourjelly.springexample.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // !!!!!!!경고!!!!!!!
    // 절대 Controller 에서 Repository 객체를 활요하지 않는다!
    // 다만, 코드 작성 편의를 위해서 임시로 활용
    @Autowired
    private StudentRepository studentRepository;

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

    @ResponseBody
    @GetMapping("/find")
    public List<Student> findStudent(){

        List<Student> studentList = null;

        // 모든 행 조회
//       studentList = studentRepository.findAll();

        // 이름으로 행조회
//        studentList =  studentRepository.findByName(name);

        // id 기반으로 내림차순 정렬
        // ORDER BY `id`DESC
//        studentList = studentRepository.findByOrderByIdDesc();

        // 이름이 김인규 이고, 2개까지 보이게 해주세요
//        studentList = studentRepository.findTop2ByNameOrderByIdDesc("김인규");

        List<String> nameList = new ArrayList<>();
        nameList.add("김인규");
        nameList.add("유재석");

//        studentList = studentRepository.findByNameIn(nameList);

        studentList = studentRepository.selectByDreamJob("개발자");



        return studentList;

    }


}
