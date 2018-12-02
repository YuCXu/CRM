package com.xyc.crm.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.xyc.crm.dao.SaleVisitDao;
import com.xyc.crm.domain.PageBean;
import com.xyc.crm.domain.SaleVisit;
import com.xyc.crm.service.SaleVisitService;
/**
 * 客户拜访的业务层的实现类
 * @author YuChen_Xu
 */
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService{
	
	//在Service中注入Dao
	@Resource(name="saleVisitDao")
	private SaleVisitDao saleVisitDao;

	@Override
	//业务层分写显示拜访记录的方法
	public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
		//封装当前页数：
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数：
		pageBean.setPageSize(pageSize);
		//封装总记录数
		Integer totalCount = saleVisitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数：
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据的集合
		Integer begin = (currPage - 1)*pageSize;
		List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
	}
}
