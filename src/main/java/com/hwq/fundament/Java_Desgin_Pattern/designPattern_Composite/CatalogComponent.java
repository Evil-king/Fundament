package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Composite;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 15:25
 * @Description: 目录主键类  课程类和课程目录都继承这个类
 */
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除操作");
    }


    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }


    public double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }


    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }
}
