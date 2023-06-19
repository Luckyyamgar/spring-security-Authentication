package com.security.model;

public class LoginResponceDTO {
	 private ApplicationUser user;
	    private String jwt;

	    public LoginResponceDTO(){
	        super();
	    }

	    public LoginResponceDTO(ApplicationUser user, String jwt){
	        this.user = user;
	        this.jwt = jwt;
	    }

	    public ApplicationUser getUser(){
	        return this.user;
	    }

	    public void setUser(ApplicationUser user){
	        this.user = user;
	    }

	    public String getJwt(){
	        return this.jwt;
	    }

	    public void setJwt(String jwt){
	        this.jwt = jwt;
	    }
}
