package com.sort.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-29 9:57
 */
public class Reminder {
    private Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    public void method(int basic, Function<Integer, Integer> function) {
        int value = function.apply(basic);
        System.out.println("Test TimerTask value = "+value);
    }

    public int func(int num) {
        return num + 2000;
    }

    public class RemindTask extends TimerTask {
        public void run() {
            Function<Integer, Integer> func = val->val+1000;
            method(20, func);
            timer.cancel(); //Terminate the timer thread
        }
    }
}
