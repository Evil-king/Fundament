package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Composite;

/**
 * @author hwq
 * @date 2018/10/17
 */
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();
}
