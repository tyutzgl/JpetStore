package com.clps.jPet.service.Impl;

import com.clps.jPet.dao.ShoppingDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zhangguoliang
 * @date 2018-01-23 15:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ShoppingServiceImplTest {

    @Autowired
    private ShoppingDao shoppingDao;

    private static Log log = LogFactory.getLog(ShoppingServiceImplTest.class);

    @Test
    public void saveShopping() {
    }

    @Test
    public void queryShopping() {
    }

    @Test
    public void deleteShopping() {
    }

    @Test
    public void updateQuantity() {
    }

    @Test
    public void queryCountShopping() {
    }

    @Test
    public void queryOneShopping() {
    }

    @Test
    public void count() {
    }
}