package com.clps.jPet.service;

import com.clps.jPet.dao.BannerdataDao;
import com.clps.jPet.pojo.Bannerdata;
import com.clps.jPet.pojo.Profile;

public interface BannerdataService {

    Bannerdata querybanner(String userid);

    Profile queryMyListOpf(String userid);

    Bannerdata querybannerTwo(String userid);

    Profile queryMyList(String userid);

    BannerdataDao getBannerdataDao();

    void setBannerdataDao(BannerdataDao bannerdataDao);
}
