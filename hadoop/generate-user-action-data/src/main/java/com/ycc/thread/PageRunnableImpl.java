package com.ycc.thread;

import com.ycc.DataCenter;
import com.ycc.action.GenerateUserLog;

/**
 * @author Uni
 * @create 2021/11/15 13:26
 */
public class PageRunnableImpl implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            synchronized (this) {
                GenerateUserLog.start();
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
