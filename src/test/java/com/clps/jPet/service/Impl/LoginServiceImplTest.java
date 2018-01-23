package com.clps.jPet.service.Impl;

import com.clps.jPet.dao.LoginDao;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangguoliang
 * @date 2018-01-23 14:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginServiceImplTest {

    @Autowired
    private LoginDao loginDao;

    private static Log log = LogFactory.getLog(LoginServiceImplTest.class);

    @Test
    public void userLogin() {
        int result = loginDao.userLogin("j2ee", "j2ee");
        log.info(result);
    }

    @Test
    public void querySignon() {
        Signon signon = loginDao.querySignon("j2ee");
        log.info(signon.getUsername() + "/-----/" + signon.getPassword());
    }

    @Test
    public void queryProfile() {
        Profile profile = loginDao.queryProfile("j2ee");
        log.info(profile.toString());
    }
}