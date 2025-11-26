package com.sourjelly.springexample.jpa.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder(toBuilder = true)// 요기서 부터 Entity전까지 어노테이션은 내가 객체를 다루기 위한 lombok 어노테이션 세팅
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity // 요기서 부터 하위는 JPA가 해당 객체를 테이블에 대응시키기 위해서 하는 어노테이션들
@Table(name="`new_student`")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String dreamJob;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
