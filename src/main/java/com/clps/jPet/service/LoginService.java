package com.clps.jPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.LoginDao;
import com.clps.jPet.domain.Account;
import com.clps.jPet.domain.Profile;
import com.clps.jPet.domain.Signon;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	
	public int userLogin(String userid,String password){
		return loginDao.userLogin(userid, password);
	}
	
	public Signon querySignon(String userid){
		
		
		return loginDao.querySignon(userid);
		
	}
	public Account queryAccount(String userid){
		
	
		return loginDao.queryAccount(userid);
		
	}
	public Profile queryProfile(String userid){
		
		
		return loginDao.queryProfile(userid);
		
	}
	
	public void saveProfile(Profile profile){
		
		loginDao.saveProfile(profile);
	}
	
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}
