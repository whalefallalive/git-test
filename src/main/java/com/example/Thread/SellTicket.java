package com.example.Thread;

//售票100张，分三个窗口售卖，使用Thread / Runnable接口实现

public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
//
//        SellTicket02 sellTicket2 = new SellTicket02();
//        new Thread(sellTicket2).start();
//        new Thread(sellTicket2).start();
//        new Thread(sellTicket2).start();

        //通过实现Runnable接口的方法，添加synchronized关键字进行加锁的方式保护数据的安全，防止线程对数据同时进行修改
//        SellTicket03 sellTicket03 = new SellTicket03();
//        new Thread(sellTicket03).start();
//        new Thread(sellTicket03).start();
//        new Thread(sellTicket03).start();


        new SellTicket04().start();
        new SellTicket04().start();
        new SellTicket04().start();

    }
}

class SellTicket01 extends Thread{
    private static int num = 100;

    @Override
    public void run() {
        while (true){
            //1、先判断还有票没
            if (num <= 0){
                System.out.println("结束售票");
                break;
            }
            //2、模拟售票的操作时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //3、给出售票剩余
            System.out.println("窗口" + Thread.currentThread().getName()+"出售一张，剩余票数为：" + --num);

        }

    }
}

class SellTicket02 implements Runnable{
    private int num = 100;
    @Override
    public void run() {
        while (true){
            //1、先判断还有票没
            if (num <= 0){
                System.out.println("结束售票");
                break;
            }
            //2、模拟售票的操作时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //3、给出售票剩余
            System.out.println("窗口" + Thread.currentThread().getName()+"出售一张，剩余票数为：" + --num);

        }
    }
}

class SellTicket03 implements Runnable{
    private int num = 100;

    private boolean loop = true;
    @Override
    //不能直接加在run方法上，这样会导致只有其他线程不能进行访问
    public void run() {
        while (loop){
            sell();
        }
    }
    //通过加synchronized来让线程调用这个方法时，只能一个线程进行调用，其他线程需要等该线程执行完成后才可以进入
    public synchronized void sell(){
            //1、先判断还有票没
            if (num <= 0){
                System.out.println("结束售票");
                loop = false;
                return;
            }
            //2、模拟售票的操作时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //3、给出售票剩余
            System.out.println("窗口" + Thread.currentThread().getName()+"出售一张，剩余票数为：" + --num);

    }
}

class SellTicket04 extends Thread{
    private static int num = 100;
    private static boolean loop = true;

    public synchronized static void sell() {
        //1、先判断还有票没
        if (num <= 0) {
            System.out.println("结束售票");
            loop = false;
            return;
        }
        //2、模拟售票的操作时间
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //3、给出售票剩余
        System.out.println("窗口" + Thread.currentThread().getName() + "出售一张，剩余票数为：" + --num);

    }

    @Override
    public void run() {
        while (loop){
            sell();
        }
    }
}

class Sell implements Runnable{
    @Override
    public void run() {
    }

    public void m1(){
        synchronized (this){
            System.out.println("m1");
        }
    }

    public synchronized void m2(){
        System.out.println("m1");
    }

    public static void m3(){
        synchronized (Sell.class){
            System.out.println("m3");
        }
    }

    public synchronized void m4(){
        System.out.println("m4");
    }
}