package com.xyc.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.xyc.crm.domain.PageBean;
import com.xyc.crm.domain.SaleVisit;

/**
 * 客户拜访的业务层的接口
 * @author YuChen_Xu
 *
 */
public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

}
