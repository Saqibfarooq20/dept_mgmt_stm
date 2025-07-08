package com.example.dept_mgmt.Controller;


import com.example.dept_mgmt.Model.UserModel;
import com.example.dept_mgmt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5174")

public class UserController {

    @Autowired
    private UserService service;
//    yscubdscbdsuchbsdbwdvbsdvbdvbhdsc   will check jhbcjsdcjbsdcdsjcsdhbcd
    @PostMapping("/login")
    public String login (@RequestBody UserModel userModel)
    {
        UserModel loggerCheck = service.login(userModel.getEmail(),userModel.getPassword());
        if(loggerCheck != null)
        {
            return loggerCheck.getRole();
        }
        return "Invalid Email or Password";
    }

    @GetMapping("/users")
    public List<UserModel> getAllUsers ()
    {
        return service.getAllUsers();
    }

    @PostMapping("/addUser")
    public UserModel addUser (@RequestBody UserModel userModel)
    {
        return service.addUser(userModel);
    }

    @PutMapping("/update/{id}")
    public UserModel updateUser (@RequestBody UserModel userModel , @PathVariable Long id)
    {
        return service.updateUser(userModel ,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser (@PathVariable Long id)
    {
        service.deleteUser(id);
        return "User Deleted Successfully";
    }

}
