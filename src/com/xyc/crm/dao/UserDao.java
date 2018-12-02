package com.xyc.crm.dao;

import com.xyc.crm.domain.User;

/**
 * �û������DAO�Ľӿ�
 * @author YuChen_Xu
 *
 */
public interface UserDao extends BaseDao<User>{

	void regist(User user);

	User login(User user);

}
