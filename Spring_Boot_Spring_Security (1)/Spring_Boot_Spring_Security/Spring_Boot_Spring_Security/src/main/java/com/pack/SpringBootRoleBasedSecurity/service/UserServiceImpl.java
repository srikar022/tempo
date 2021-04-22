package com.pack.SpringBootRoleBasedSecurity.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pack.SpringBootRoleBasedSecurity.model.Role;
import com.pack.SpringBootRoleBasedSecurity.model.User;
import com.pack.SpringBootRoleBasedSecurity.model.changePassword;
import com.pack.SpringBootRoleBasedSecurity.repository.RoleRepository;
import com.pack.SpringBootRoleBasedSecurity.repository.UserRepository;


@Transactional
@Service
public  class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	@Override
	public void saveRole(Iterable i) {
		roleRepository.saveAll(i);
	}

	@Override
	public void changePwd(changePassword userForm1) {
		// TODO Auto-generated method stub
	User data =userRepository.findByUsername(userForm1.getUname());

		if(data.getPasswordConfirm().equalsIgnoreCase(userForm1.getOpwd())) {
			userRepository.cp(userForm1.getUname(),bCryptPasswordEncoder.encode(userForm1.getPwd()));
		}
	
		
	}
}
