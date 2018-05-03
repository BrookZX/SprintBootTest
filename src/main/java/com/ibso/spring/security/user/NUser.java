package com.ibso.spring.security.user;
    

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany; 
 

@Entity  
public class NUser {  
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String username;
 
    private String password;
 
    private String email;
 
    private Date lastPasswordResetDate;
    
    
    
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private List<SysRole> roles;
    
	public NUser(Long id, String username, String password, String email, Date lastPasswordResetDate,
			List<SysRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.roles = roles;
	}
	
	public NUser( ) {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
    
    
    
}
