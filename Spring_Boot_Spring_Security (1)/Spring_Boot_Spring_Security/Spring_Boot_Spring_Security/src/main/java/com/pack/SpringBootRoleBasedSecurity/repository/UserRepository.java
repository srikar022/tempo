package com.pack.SpringBootRoleBasedSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.SpringBootRoleBasedSecurity.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    
    @Modifying
    @Query("UPDATE User u set u.password=:pwd WHERE u.username=:uname")
	void cp(@Param("uname") String uname, @Param("pwd") String pwd);
}