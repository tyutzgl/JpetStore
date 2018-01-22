package com.clps.jPet.dao;

import com.clps.jPet.pojo.Bannerdata;
import com.clps.jPet.pojo.Profile;

public interface BannerdataDao {

    /**
     * get user's bannerdata
     * @param userid
     * @return Bannerdata
     */
    Bannerdata querybanner(String userid);

    /**
     * get user's profile
     * @param userid
     * @return Profile
     */
    Profile queryMyListOpf(String userid);

    /**
     * get user's profile 2
     * @param userid
     * @return Profile
     */
    Profile queryMyList(String userid);
}
