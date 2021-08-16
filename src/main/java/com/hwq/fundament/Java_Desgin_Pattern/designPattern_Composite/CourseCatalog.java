package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/1/31 0031 15:27
 * @Description: 课程目录类
 */
public class CourseCatalog extends CatalogComponent {

    private String name;

    private Integer level;

    private List<CatalogComponent> list = new ArrayList<CatalogComponent>();

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        list.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        list.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : list) {
            if(level != null){
                for(int  i = 0; i < this.level; i++){
                    System.out.print("  ");
                }
            }
            catalogComponent.print();
        }
    }
}
