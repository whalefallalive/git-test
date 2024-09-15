package com.example.Thread;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        Method01 method01 = new Method01();
        method01.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " = hi " + i);
            //当调用join方法时，会先将该线程的程序先执行完毕后，在执行其他程序（插队）
            if (i == 4){method01.join();}
            //当调用yield方法时，该线程会礼让其他线程，也可能会继续执行
            // （CPU同时对多个线程继续执行时，比较忙碌的情况下会优先执行其他的线程）
            //if (i == 4){method01.yield();}
        }
    }
}

class Method01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " = hello " + i);
        }
    }
}
