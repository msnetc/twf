package com.taimeitech.platform.service.activiti;

import java.util.List;

/**
 * Created by yanjie.miao on 2017/6/29.
 */
public class PageList <T>{

    public PageList(List<T> items, long cnt){
        data = items;
        count=cnt;
    }

    private List<T> data;

    private long count;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
