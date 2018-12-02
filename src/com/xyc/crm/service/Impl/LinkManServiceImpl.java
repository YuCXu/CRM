package com.xyc.crm.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.xyc.crm.dao.LinkManDao;
import com.xyc.crm.domain.LinkMan;
import com.xyc.crm.domain.PageBean;
import com.xyc.crm.service.LinkManService;
/**
 * 联系人管理的业务层的实现类
 * @author YuChen_Xu
 *
 */
@Transactional
public class LinkManServiceImpl implements LinkManService{
	
	//注入Dao
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	@Override
	/**
	 * 业务层分页查询联系人的方法
	 */
	public PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		//封装PageBean
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		//封装当前页
		pageBean.setCurrPage(currPage);
		//封装当前页显示的信息数
		pageBean.setPageSize(pageSize);
		//封装联系人的总信息数
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double totalPage = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//封装每页显示数据的集合
		Integer begin = (currPage - 1)*pageSize;
		List<LinkMan> list = linkManDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	@Override
	//业务层保存联系人的方法
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}
	
	
	@Override
	//业务层根据id查询联系人的方法
	public LinkMan findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);
	}
	
	@Override
	//业务层修改联系人的方法
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}
	
	@Override
	//业务层删除联系人的方法
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
}
