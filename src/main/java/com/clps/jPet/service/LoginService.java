package com.clps.jPet.service;

import com.clps.jPet.dao.LoginDao;
import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;

public interface LoginService {

    int userLogin(String userid, String password);

    Signon querySignon(String userid);

    Account queryAccount(String userid);

    Profile queryProfile(String userid);

    void saveProfile(Profile profile);

    LoginDao getLoginDao();

    void setLoginDao(LoginDao loginDao);
}
