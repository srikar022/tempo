package com.pack.SpringBootRoleBasedSecurity.service;


import com.pack.SpringBootRoleBasedSecurity.model.User;
import com.pack.SpringBootRoleBasedSecurity.model.changePassword;

public interface UserService {
    void save(User user);
    void saveRole(Iterable i);
    User findByUsername(String username);
	void changePwd(changePassword userForm1);
	
}