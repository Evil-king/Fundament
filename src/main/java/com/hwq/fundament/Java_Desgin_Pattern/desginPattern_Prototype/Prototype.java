package com.hwq.fundament.Java_Desgin_Pattern.desginPattern_Prototype;

/**
 * @author hwq
 * @date 2019/04/05
 * <p>
 * 原型类
 * </p>
 */
public abstract class Prototype {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract Prototype clone();
}
