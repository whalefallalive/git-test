package com.example.Thread;

public class Thread02 {
    public static void main(String[] args) {
        //创建Dog对象
        Dog dog = new Dog();
        //将Dog对象给到Thread类，在通过Thread类去调用start方法，在通过该方法调用Dog类的run方法
        //这个位置使用了静态代理（设计者模式）
        Thread thread = new Thread(dog);
        thread.start();
    }
}
class Dog implements Runnable{
    int couts = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("www " + (++couts) + "线程的名字=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (couts == 10){
                break;
            }
        }

    }
}