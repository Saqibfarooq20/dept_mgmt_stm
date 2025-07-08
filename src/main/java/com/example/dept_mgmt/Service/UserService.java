package com.example.dept_mgmt.Service;

import com.example.dept_mgmt.Model.UserModel;
import com.example.dept_mgmt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel login(String email , String password) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<UserModel> getAllUsers ()
    {
        return userRepository.findAll();
    }

    public UserModel addUser(UserModel userModel)
    {
        return userRepository.save(userModel);
    }

    public UserModel getUserById (Long id )
    {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel updateUser (UserModel userModel, Long id)
    {
        UserModel existUser = userRepository.findById(id).orElse(null);
        if(existUser != null)
        {
            existUser.setName(userModel.getName());
            existUser.setDepartment(userModel.getDepartment());
            existUser.setPassword(userModel.getPassword());
            return userRepository.save(existUser);
        }
        return null;
    }

    public void deleteUser (Long id)
    {
        userRepository.deleteById(id);
    }
}
