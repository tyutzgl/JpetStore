package com.clps.jPet.service;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;

public interface LoginService {
    /**
     * Determine whether the user is log in
     *
     * @param userid
     * @param password
     * @return int>0 login success
     */
    int userLogin(String userid, String password);

    /**
     * query signon  by userId
     *
     * @param userid
     * @return
     */
    Signon querySignon(String userid);

    /**
     * Query account by user's id
     *
     * @param userid
     * @return
     */
    Account queryAccount(String userid);

    /**
     * Query user's profile by user's id
     *
     * @param userid
     * @return
     */
    Profile queryProfile(String userid);

    /**
     * save user's profile
     *
     * @param profile
     */
    void saveProfile(Profile profile);

}
