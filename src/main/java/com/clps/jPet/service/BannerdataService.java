package com.clps.jPet.service;

import com.clps.jPet.pojo.Bannerdata;
import com.clps.jPet.pojo.Profile;

public interface BannerdataService {

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
}
