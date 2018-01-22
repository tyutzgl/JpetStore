package com.clps.jPet.service;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;


public interface RegisterService {
    /**
     * Save user information to login form
     *
     * @param signon
     */
    void insertSigno(Signon signon);

    /**
     * Save user information to profile form
     *
     * @param profile
     */
    void insertProfile(Profile profile);

    /**
     * Save user information to account form
     *
     * @param account
     */
    void insertAccount(Account account);

}
