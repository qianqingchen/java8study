package com.study.concurrent;

/**
 * 一个最简单的deadLock的实现
 *
 */
public class DeadLock {
    private static Object firstMonitor = new Object();
    private static Object secondMonitor = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable(){
            public void run() {
                while(true)
                {
                    synchronized(firstMonitor)
                    {
                        synchronized(secondMonitor)
                        {
                            System.out.println("Thread1");
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run() {
                while(true)
                {
                    synchronized(secondMonitor)
                    {
                        synchronized(firstMonitor)
                        {
                            System.out.println("Thread2");
                        }
                    }
                }
            }
        }).start();
    }
}