package com.chk.pdms.common.vo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private long total;
	private List<T> rows;

	public Page(List<T> list, int total) {
		this.rows = list;
		this.total = total;
	}

	public Page(List<T> list) {
		if(list instanceof com.github.pagehelper.Page) {
			com.github.pagehelper.Page page = (com.github.pagehelper.Page)list;
			this.rows = list;
			this.total = page.getTotal();
		}else{
			this.rows = list;
			this.total = list.size();
		}
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
