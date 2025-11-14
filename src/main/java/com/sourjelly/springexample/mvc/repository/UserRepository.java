package com.sourjelly.springexample.mvc.repository;


import com.sourjelly.springexample.mvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {


    public User selectLastUser();

    public int insertUser(
            @Param("name") String name
            ,@Param("birthday") String birthday
            ,@Param("email") String email
            ,@Param("introduce") String introduce);

    public int insertUserByObject(User user);
}

