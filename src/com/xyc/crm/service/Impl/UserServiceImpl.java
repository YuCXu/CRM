package com.xyc.crm.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xyc.crm.dao.UserDao;
import com.xyc.crm.domain.User;
import com.xyc.crm.service.UserService;
import com.xyc.crm.utils.MD5Utils;
/**
 * �û������Service���ʵ����
 * @author YuChen_Xu
 *
 */

@Transactional
public class UserServiceImpl implements UserService{
	
	//ע��Dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	//业务层用户注册的方法
	public void regist(User user) {
		//��������м��ܴ���
		String password = MD5Utils.md5(user.getUser_password());
		user.setUser_password(password);
		user.setUser_state("1");
		//����Dao
		userDao.regist(user);
	}

	@Override
	//业务层用户登录的方法
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//����Dao
		return userDao.login(user);
	}

	@Override
	public List<User> findAll() {
		List<User> list = userDao.findAll();
		return list;
	}

}
