package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	
	public LoginBean() {
		
	}
	
	public LoginBean(String email, String passwd) {
		
		this.email = email;
		this.passwd = passwd;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl()) {
			User u = userDao.findByEmail(email);
			System.out.println("Hello "+ u);
			if(u != null  && u.getPassword().equals(passwd))
				this.user = u;
			else
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


