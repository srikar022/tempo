package com.pack.SpringBootRoleBasedSecurity.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		    @Column(name="role_id")
    private Long id;
    private String name;
   

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
