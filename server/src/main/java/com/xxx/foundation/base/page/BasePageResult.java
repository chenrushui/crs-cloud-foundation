package com.xxx.foundation.base.page;

import java.util.List;

/**
 * Created on 2020/4/16 18:26
 * author:crs
 * Description:请求响应
 */
public class BasePageResult<T> {

    //当前第几页
    private int pageNum;
    //每页多少条记录
    private int pageSize;
    //总的记录数
    private Long total;
    private List<T> list;

    public BasePageResult() {
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
