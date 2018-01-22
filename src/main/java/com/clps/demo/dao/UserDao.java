package com.clps.demo.dao;

import com.clps.demo.domain.User;

import java.util.List;

public interface UserDao {
	/**
	 * 添加新用户
	 * @param user
	 */
	public void saveUser(User user);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
    public User findUserById(int id);  
    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    public List<User> findUserByName(String name);  
    /**
     * 移除用户
     * @param user
     */
    public void removeUser(User user);
    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

}
