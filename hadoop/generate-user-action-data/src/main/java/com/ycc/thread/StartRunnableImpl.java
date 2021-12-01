package com.ycc.thread;

import com.ycc.DataCenter;
import com.ycc.action.GenerateStartLog;

/**
 * @author Uni
 * @create 2021/11/15 13:25
 */
public class StartRunnableImpl implements Runnable{
    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                GenerateStartLog.start();
                DataCenter.saveLog();
            }
            try {
                Thread.sleep(DataCenter.OPTION_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
