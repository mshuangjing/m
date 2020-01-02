package com.byzoro.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ViewResult {

	public final static int SUCCESS = 1;
	public final static int ERROR = 0;
	public final static int NO_LOGIN = -1;

	private int status = SUCCESS;
	private List<?> data = new ArrayList<>();
	private String info = "操作成功";
	private String error = "";

	private int totalNum = 0;//默认总数
	@JsonIgnore
	private int pageNum = 1;//分页默认页码
	@JsonIgnore
	private int pageSize = 10;//分页默认页大小

	private Object obj;

	public ViewResult() {
		super();
	}

	public ViewResult(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
		if (o == null || getClass() != o.getClass()) {
            return false;
        }

		ViewResult that = (ViewResult) o;

		if (status != that.status) {
            return false;
        }
		if (totalNum != that.totalNum) {
            return false;
        }
		if (data != null ? !data.equals(that.data) : that.data != null) {
            return false;
        }
		if (info != null ? !info.equals(that.info) : that.info != null) {
            return false;
        }
		return error != null ? error.equals(that.error) : that.error == null;

	}

	@Override
	public int hashCode() {
		int result = status;
		result = 31 * result + (data != null ? data.hashCode() : 0);
		result = 31 * result + (info != null ? info.hashCode() : 0);
		result = 31 * result + (error != null ? error.hashCode() : 0);
		result = 31 * result + totalNum;
		return result;
	}

	@Override
	public String toString() {
		return "ViewResult{" + "status=" + status + ", data=" + data
				+ ", info='" + info + '\'' + ", error='" + error + '\''
				+ ", totalNum=" + totalNum + '}';
	}
}
