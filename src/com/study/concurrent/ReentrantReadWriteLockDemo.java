package com.study.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * ��д������Ϊ������д����������������⣬������д�����⣬������jvm�Լ����Ƶģ���ֻҪ�Ϻ���Ӧ�������ɡ�
 * �����Ĵ���ֻ�����ݣ����Ժܶ���ͬʱ����������ͬʱд���Ǿ��϶����������Ĵ����޸����ݣ�ֻ����һ������д���Ҳ���ͬʱ��ȡ���Ǿ���д����
 * ��֮������ʱ���϶�����д��ʱ����д����
 * 
 * �߳̽��������ǰ�������� û�������̵߳�д���� û��д���������д���󣬵������̺߳ͳ��������߳���ͬһ��
 * 
 * �߳̽���д����ǰ�������� û�������̵߳Ķ��� û�������̵߳�д��
 * 
 * ��ReentrantReadWriteLock������Ҫ��������ReentrantLock������ޡ����ͺ��߶��ǵ�����ʵ�֣��˴�֮��û�м̳л�ʵ�ֵĹ�ϵ��Ȼ������ܽ���������Ƶ������ˣ�
 * (a).���뷽�����ڲ���WriteLock���Ի�ȡReadLock�����Ƿ�����ReadLock��Ҫ���WriteLock����Զ����Ҫ�롣
 * (b).WriteLock���Խ���ΪReadLock��˳���ǣ��Ȼ��WriteLock�ٻ��ReadLock��Ȼ���ͷ�WriteLock����ʱ���߳̽�����Readlock�ĳ��С�������ReadLock��Ҫ����ΪWriteLock�򲻿��ܣ�Ϊʲô���ο�(a)���Ǻ�.
 * (c).ReadLock���Ա�����̳߳��в���������ʱ�ų��κε�WriteLock����WriteLock������ȫ�Ļ��⡣��һ������Ϊ��Ҫ����Ϊ���ڸ߶�ȡƵ�ʶ���Խϵ�д������ݽṹ��ʹ�ô�����ͬ�������������߲�������
 * (d).������ReadLock����WriteLock��֧��Interrupt��������ReentrantLockһ�¡�
 * (e).WriteLock֧��Condition������ReentrantLock����һ�£���ReadLock����ʹ��Condition�������׳�UnsupportedOperationException�쳣��
 * 
 *
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();
        for(int i=0;i<3;i++)
        {
            new Thread(){
                public void run(){
                    while(true){
                        q3.get();                        
                    }
                }
                
            }.start();
        }
        for(int i=0;i<3;i++)
        {        
            new Thread(){
                public void run(){
                    while(true){
                        q3.put(new Random().nextInt(10000));
                    }
                }            
                
            }.start();    
        }
    }
}

class Queue3{
    private Object data = null;//�������ݣ�ֻ����һ���߳���д�����ݣ��������ж���߳�ͬʱ�������ݡ�
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public void get(){
        rwl.readLock().lock();//�϶����������߳�ֻ�ܶ�����д
        System.out.println(Thread.currentThread().getName() + " be ready to read data!");
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "have read data :" + data);        
        rwl.readLock().unlock(); //�ͷŶ�������÷���finnaly����
    }
    
    public void put(Object data){

        rwl.writeLock().lock();//��д���������������̶߳�Ҳ������д
        System.out.println(Thread.currentThread().getName() + " be ready to write data!");                    
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;        
        System.out.println(Thread.currentThread().getName() + " have write data: " + data);                    
        
        rwl.writeLock().unlock();//�ͷ�д��    
    }
}