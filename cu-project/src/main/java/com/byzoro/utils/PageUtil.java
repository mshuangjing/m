package com.byzoro.utils;


public class PageUtil {
	private int pageSize;// 每页显示的条数
	private int recordCount;// 总共的条数
	private int currentPage;// 当前页面

	public PageUtil(int pageSize, int recordCount, int currentPage){
            this.pageSize = pageSize;
            this.recordCount = recordCount;
            setCurrentPage(currentPage);
            
        }

	// 构造方法
	public PageUtil(int pageSize, int recordCount){
            this(pageSize, recordCount, 1);
        }

	// 总页数
	public int getPageCount() {
            int size = recordCount/pageSize;//总条数/每页显示的条数=总页数
            int mod = recordCount % pageSize;//最后一页的条数
            if(mod != 0) {
                size++;
            }
            return recordCount == 0 ? 1 : size;
        }

	/**
	 * 包含，起始索引为0,用来传递给mybatis的page参数
	 * @return
	 */
	public int getFromIndex() {
            return (currentPage-1) * pageSize;
        }

	// 不包含
	public int getToIndex() {
            return  Math.min(recordCount, currentPage * pageSize);
        }

	// 得到当前页
	public int getCurrentPage() {
            return currentPage;
        }// 设置当前页

	public void setCurrentPage(int currentPage) {
            int validPage = currentPage <= 0 ? 1 : currentPage;
            validPage = validPage > getPageCount() ? getPageCount() : validPage;
            this.currentPage = validPage;
        }// 得到每页显示的条数

	public int getPageSize() {
            return pageSize;
        }// 设置每页显示的条数

	public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }// 得到总共的条数

	public int getRecordCount() {
            return recordCount;
        }// 设置总共的条数

	public void setRecordCount(int recordCount) {
            this.recordCount = recordCount;
        }

}
