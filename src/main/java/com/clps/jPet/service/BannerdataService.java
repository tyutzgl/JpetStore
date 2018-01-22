package com.clps.jPet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.jPet.dao.BannerdataDao;
import com.clps.jPet.domain.Bannerdata;
import com.clps.jPet.domain.Profile;

@Service
public class BannerdataService {

	@Autowired
	private BannerdataDao bannerdataDao;

	public Bannerdata querybanner(String userid) {
		return bannerdataDao.querybanner(userid);
	}

	public Profile queryMyListOpf(String userid) {

		return bannerdataDao.queryMyListOpf(userid);
	}
	
	public Bannerdata querybannerTwo(String userid){
		
		return bannerdataDao.querybanner(userid);
	}
	
	
	public Profile queryMyList(String userid){
		
		return bannerdataDao.queryMyList(userid);
	}
	
	public BannerdataDao getBannerdataDao() {
		return bannerdataDao;
	}

	public void setBannerdataDao(BannerdataDao bannerdataDao) {
		this.bannerdataDao = bannerdataDao;
	}
}
