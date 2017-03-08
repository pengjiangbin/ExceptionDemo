package com.padoon.exceptiondemo.data;

import java.util.List;

/**
 * Created by jiang on 2017/3/8.
 */

public class ArticleList {
    private int total;
    private List<Article> list;
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List<Article> getList() {
        return list;
    }
    public void setList(List<Article> list) {
        this.list = list;
    }
}
