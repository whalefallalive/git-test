package com.example.Thread;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}

class A extends Thread{

    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            //随机生成100以内的整数
            System.out.println((int) (Math.random() * 100 +1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }


}

class B extends Thread{
    private Scanner sc = new Scanner(System.in);

    private A a;

    public B() {
    }

    public B(com.example.Thread.A A) {
        this.a = A;
    }

    @Override
    public void run() {
        while (true){
           System.out.println("输入（Q）结束程序：");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            char c = sc.next().toUpperCase().charAt(0);
            if (c == 'Q'){
                a.setLoop(false);
            }
            System.out.println("程序结束");
            break;
        }
    }


}