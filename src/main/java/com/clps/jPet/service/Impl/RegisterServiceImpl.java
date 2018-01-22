package com.clps.jPet.service.Impl;

import com.clps.jPet.dao.RegisterDao;
import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;
import com.clps.jPet.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{
	
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
