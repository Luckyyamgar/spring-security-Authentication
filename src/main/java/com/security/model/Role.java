package com.security.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int roleId;
	
	private String authority;
	
	public Role(String authority) {
		this.authority = authority;
	}
    public Role(int roleId,String authority) {
    	this.roleId=roleId;
    	this.authority=authority;
    }
    
    
     public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getAuthority() {
		
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	

}
