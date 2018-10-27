package com.hwq.fundamment.Think_In_Java.innerClass.TestExtenalClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwq
 * @date 2018/10/23
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<>(eventList)) { //为啥要新建一个list？
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
