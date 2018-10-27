package com.hwq.fundamment.Java_Desgin_Pattern.designPattern_Composite;


/**
 * @author hwq
 * @date 2018/10/17
 * <p>
 *     图像文件类：叶子构件
 * </p>
 */
public class ImageFile extends AbstractFile {


    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    public void killVirus() {
        //模拟杀毒
        System.out.println("----对图像文件'" + name + "'进行杀毒");
    }
}
