package com.xyc.crm.service.Impl;

import java.util.List;

import com.xyc.crm.dao.BaseDictDao;
import com.xyc.crm.domain.BaseDict;
import com.xyc.crm.service.BaseDictService;

/**
 * �ֵ��Service���ʵ����
 * @author YuChen_Xu
 *
 */
public class BaseDictServiceImpl implements BaseDictService {
	
	//ע��Dao
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	@Override
	
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}
}
