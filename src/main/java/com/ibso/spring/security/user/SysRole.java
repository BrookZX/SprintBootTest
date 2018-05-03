package com.ibso.spring.security.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class SysRole implements GrantedAuthority{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
 
    public SysRole() { 
		super();
	}

    public SysRole(String name) {
    	this.name  = name; 
    }

    public SysRole(Long id, String name) {
    	this.id  = id; 
    	this.name  = name; 
    }
    
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

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
}