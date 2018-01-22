package com.clps.jPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.RegisterDao;
import com.clps.jPet.domain.Account;
import com.clps.jPet.domain.Profile;
import com.clps.jPet.domain.Signon;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterDao registerDao;

	public void insertSigno(Signon signon){
		registerDao.insertSigno(signon);
	}
	
	public void insertProfile(Profile profile){
		registerDao.insertProfile(profile);
		
	}
	
	public void insertAccount(Account account){
		registerDao.insertAccount(account);
		
	}
	
	
	public RegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}
}
