package com.hwq.fundament.Java_Desgin_Pattern.designPattern_Singleton;

import java.io.*;

/**
 * @author hwq
 * @date 2019/10/20
 */
public class Test {

//    public static void main(String[] args) {
//        Thread thread1 = new Thread(new T());
//        Thread thread2 = new Thread(new T());
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println("project is end");
//    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySingleton instance = HungrySingleton.getInsence();

        ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream("stream.txt"));
        oos.writeObject(instance);

        File file = new File("stream.txt");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton newInstance =  (HungrySingleton)ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
