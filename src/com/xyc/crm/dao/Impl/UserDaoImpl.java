package com.xyc.crm.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xyc.crm.dao.UserDao;
import com.xyc.crm.domain.User;
/**
 * �û������DAO��ʵ����
 * @author YuChen_Xu
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	
	@Override
	//Dao�б����û��ķ���
	public void regist(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	//Dao�и����û�����������в�ѯ�ķ���
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?"
				, user.getUser_code(),user.getUser_password());
		//�ж�list�Ƿ�Ϊ��
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
