package com.xxx.foundation.base.page;

/**
 * Created on 2020/4/16 18:24
 * author:crs
 * Description:分页查询请求
 */
public class BasePageRequest {

    //页码数，默认查询第一页
    private int pageNum;
    //每页记录数，默认每页查询十条记录
    private int pageSize;

    public int getPageNum() {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (pageSize<=0){
            pageSize=10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}