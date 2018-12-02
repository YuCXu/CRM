package com.xyc.crm.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.xyc.crm.dao.BaseDao;

/**
 * 通用的Dao的实现类
 * @author YuChen_Xu
 *
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	
	private Class clazz;
	//提供构造方法，在构造方法中传入具体类型的class
	/**
	 * 不想子类有构造方法，必须在父类中提供无参构造，在无参构造中获得具体类型的Class
	 * 具体类型的Class是参数类型中实际的类型参数
	 */
	public BaseDaoImpl() {
		//反射：第一步获得Class
		Class clazz = this.getClass();//正在被调用的那个类的Class，CustomerDaoImpl或者LinkManDaoImpl
		//查看JDK的API
		Type type = clazz.getGenericSuperclass();//参数化类型：BaseDaoImpl<Customer>,BaseDaoImpl<LinkMan>
		System.out.println(type);
		//得到的这个type就是一个参数化的类型，将type强转成参数化类型
		ParameterizedType pType = (ParameterizedType) type;
		//通过参数化类型获得实际类型参数：得到一个实际类型参数的数组？Map<String，Integer>
		Type[] types = pType.getActualTypeArguments();
		//是活的第一个实际类型参数即可：
		this.clazz = (Class) types[0];  //得到Customer、LinkMan、User
	}
	
	@Override
	public void save(Object t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(Object t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Object t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	//查询所有的方法
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}

	@Override
	//统计个数的方法
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//设计统计个数的条件
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

}
