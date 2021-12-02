package com.scanbuy.scanbook.beans;

import java.util.List;
import java.util.Set;

public class SelectQueryBean {
	private List<Object> rsObjList;
	
	private List<String> columnNames;

	private Long timeTaken;

	public List<Object> getRsObjList() {
		return rsObjList;
	}

	public void setRsObjList(List<Object> rsObjList) {
		this.rsObjList = rsObjList;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	public Long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public SelectQueryBean() {
	}
}
