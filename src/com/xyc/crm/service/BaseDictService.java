package com.xyc.crm.service;

import java.util.List;

import com.xyc.crm.domain.BaseDict;

/**
 * 字典的Service层的接口
 * @author YuChen_Xu
 *
 */
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);
}
