package com.xyc.crm.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xyc.crm.dao.BaseDictDao;
import com.xyc.crm.domain.BaseDict;
/**
 * 字典的Dao的实现类
 * @author YuChen_Xu
 *
 */
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict "
				+ "where dict_type_code=?", dict_type_code);
		return list;
	}

}
