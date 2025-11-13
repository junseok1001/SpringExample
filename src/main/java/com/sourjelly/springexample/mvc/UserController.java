package com.sourjelly.springexample.mvc;

import com.sourjelly.springexample.mvc.domain.User;
import com.sourjelly.springexample.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mvc/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 가장 최근 등록된 사용자 정보를 html 로 구성해서 보여주기
    @GetMapping("/info")
    public String userInfo(Model model){

        // 가장 최근 등록된 사용자 정보 얻어오기
        User user = userService.getLastUser();

        model.addAttribute("title", "최근 등록 사용자");
        model.addAttribute("result", user);

        return "mvc/userInfo";
    }

//    @RequestMapping(value="/add" , method= RequestMethod.POST)
    @ResponseBody
    @PostMapping("/add")
    public String addUser(
            @RequestParam("name") String name
            ,@RequestParam("birthday") String birthday
            ,@RequestParam("email") String email
            ,@RequestParam(value = "introduce", required=false) String introduce){

        int count = userService.createUser(name, birthday, email, introduce);

        return "입력 완료 : " +  count;
    }

    @GetMapping("/form")
    public String userForm(){

        return "mvc/userForm";

    }
}
