package com.xyc.crm.service;

import java.util.List;

import com.xyc.crm.domain.BaseDict;

/**
 * �ֵ��Service��Ľӿ�
 * @author YuChen_Xu
 *
 */
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);
}
