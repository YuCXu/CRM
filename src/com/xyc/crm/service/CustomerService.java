package com.xyc.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xyc.crm.domain.Customer;
import com.xyc.crm.domain.PageBean;

/**
 * Service层客户管理的接口
 * @author YuChen_Xu
 *
 */
public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();

}
