package com.clps.demo.service.Impl;

import com.clps.demo.dao.UserDao;
import com.clps.demo.domain.User;
import com.clps.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangguoliang
 * @date 2018-01-08 11:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String userServiceDemo() {
        String string = "spring搭建成功";
        User user = userDao.findUserById(1);
        System.out.println(user.toString());
        return string;
    }

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = userDao.findUserById(id);
		System.out.println(user.toString());
		return user;
	}
}
