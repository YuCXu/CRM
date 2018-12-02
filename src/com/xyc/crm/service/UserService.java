package com.xyc.crm.service;

import java.util.List;

import com.xyc.crm.domain.User;

/**
 * �û������Service��Ľӿ�
 * @author YuChen_Xu
 *
 */
public interface UserService {

	void regist(User user);

	User login(User user);

	List<User> findAll();

}
