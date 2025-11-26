package com.sourjelly.springexample.jpa.service;

import com.sourjelly.springexample.jpa.domain.Student;
import com.sourjelly.springexample.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(
            String name
            , String phoneNumber
            , String email
            , String dreamJob
    ){
        Student student = Student.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .dreamJob(dreamJob)
                .build();
        Student result = studentRepository.save(student);


        return result;
    }

    public Student updateStudent(int id , String dreamJob){

        //1. 수정 대상을 객체로 얻어온다.
        //2. 해당 객체 정보에서 수정사항을 적용한다.
        //3. 수정된 객체를 저장한다.

        // Option 객체의 의미
        // 이놈은 NUll일 가능성이 있는 객체를 감싸 놓은 객체
        // 감싼 객체가 null 인 경우에 대한 처리를 위한 기능 포함되어 있음.
        // null 인 상태에서 객체를 다룰때, NullPointerException의 위험을 줄이기 위한 용도
        // null 일수 있는 객체를 리턴하는 매서드에서 리턴타입으로 활용.
        // (대화체 : 내가 만든 매서드가 null을 리턴 할 수 도 있으니 조심해서 다뤄라)
        Optional<Student> optionalStudent = studentRepository.findById(id);


        if(optionalStudent.isPresent()){
            // null 이 아니다.
            Student student = optionalStudent.get();

            student = student.toBuilder().dreamJob(dreamJob).build();

            Student result = studentRepository.save(student);

            return result;
        }else{
            //null 이다.

            return null;
        }
    }


    public void deleteStudent(int id){
        // 1. 삭제 대상을 객체로 얻어온다.
        // 2. 대상 객체로 삭제한다.

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()){
            // null이 아니다
            Student student = optionalStudent.get();
            studentRepository.delete(student);

        }else{
            // null 이다
        }

    }
}
