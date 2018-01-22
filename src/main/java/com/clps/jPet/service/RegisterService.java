package com.clps.jPet.service;

import com.clps.jPet.dao.RegisterDao;
import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;


public interface RegisterService {

    void insertSigno(Signon signon);

    void insertProfile(Profile profile);

    void insertAccount(Account account);

    RegisterDao getRegisterDao();

    void setRegisterDao(RegisterDao registerDao);
}
