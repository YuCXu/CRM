package com.xyc.crm.domain;

import java.util.List;

public class PageBean<T> {
	private Integer currPage;   //��ǰҳ
	private Integer pageSize;   //当前页显示的信息数
	private Integer totalCount; //总的信息数
	private Integer totalPage;  //总页数
	private List<T> list;       //ÿҳ��ѯ�����ݵļ���
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
