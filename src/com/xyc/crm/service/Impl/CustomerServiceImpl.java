package com.xyc.crm.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.xyc.crm.dao.CustomerDao;
import com.xyc.crm.domain.Customer;
import com.xyc.crm.domain.PageBean;
import com.xyc.crm.service.CustomerService;

/**
 * 客户管理业务层的实现类
 * @author YuChen_Xu
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	//注入客户的Dao
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	//业务层保存客户的方法
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	//业务层分页查询客户的方法
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//封装当前页数：
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		//调用Dao
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据的集合
		Integer begin = (currPage-1)*pageSize;
		List<Customer> list = customerDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//根据id查询客户的方法
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}

	@Override
	//删除客户的方法
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	//更新客户的方法
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	//业务层查询所有客户的方法
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
}
