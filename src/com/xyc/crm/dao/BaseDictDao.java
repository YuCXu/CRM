package com.xyc.crm.dao;

import java.util.List;

import com.xyc.crm.domain.BaseDict;

/**
 * 字典管理的Dao的接口
 * @author YuChen_Xu
 *
 */
public interface BaseDictDao {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
