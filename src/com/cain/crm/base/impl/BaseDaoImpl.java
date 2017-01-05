package com.cain.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cain.crm.base.BaseDao;
import com.cain.crm.page.PageHibernateCallback;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	//T  编译时，注释变量。在运行时，才可以获得具体的类型
	private Class<?> beanClass;
	public BaseDaoImpl() {
		//获得运行时的类型 , BaseDaoImpl<CrmStaff>被参数化的类型
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得实际参数的 ,获得所有。此时只有一个
		beanClass = (Class<?>) paramType.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(beanClass,id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from"+beanClass.getClass());
	}


	@Override
	public List<T> findAll(String condition, Object[] params) {
		String hql = "from "+beanClass.getName()+" where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql , params);
	}


	@Override
	public int getTotalRecord(String condition, Object[] params) {
		String hql = "select count(c) from "+beanClass.getName()+" c where 1=1 " + condition;
		List<Long> list = this.getHibernateTemplate().find(hql,params);
		return list.get(0).intValue();
	}

	@Override
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize) {
		String hql = "from "+beanClass.getName()+" where 1=1 " + condition;
		return this.getHibernateTemplate().execute(new PageHibernateCallback<T>().setHql(hql).setParams(params).setPageSize(pageSize).setStartIndex(startIndex));
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
		return this.getHibernateTemplate().findByCriteria(criteria, startIndex, pageSize);
	}

}