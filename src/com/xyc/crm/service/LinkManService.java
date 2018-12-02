package com.xyc.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.xyc.crm.domain.LinkMan;
import com.xyc.crm.domain.PageBean;

/**
 * 联系人管理的业务层的接口
 * @author YuChen_Xu
 *
 */
public interface LinkManService {

	PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}
