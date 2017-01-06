package com.cain.crm.base;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public void saveOrUpdate(T t);
	
	public T findById(java.io.Serializable id);
	
	public List<T> findAll();
	
	/**
	 * 条件查询
	 * @param condition ，格式：" and ..? and ..."
	 * @param params
	 * @return
	 */
	public List<T> findAll(String condition, Object[] params);
	

	/**
	 * 分页，查询总记录数
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition, Object[] params);

	/**
	 * 分页，查询结果
	 * @param condition 条件
	 * @param params 条件实际参数
	 * @param startIndex 开始索引
	 * @param pageSize 每页显示个数
	 * @return
	 */
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize);
	
	
	/**
	 * 离线条件查询，使用QBC
	 * @param criteria
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria);
	/**
	 * 分页
	 * @param criteria
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria , int startIndex ,int pageSize);
}
