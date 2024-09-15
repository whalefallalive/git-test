package com.example.Thread;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        Method02 method02 = new Method02();
        //我们希望，在主线程执行完成后，子线程也结束执行 -> 那么就可以将子线程修改成守护线程
        method02.setDaemon(true);//将该线程修改成守护线程
        method02.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("gq 在打单子、、、");
        }
        Method03 method03 = new Method03();
        method03.start();
    }
}

class Method02 extends Thread{
    @Override
    public void run() {
        for ( ; ; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ctwo 在写代码、、、");
        }
    }
}

class Method03 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<=10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("wql 在写代码、、、");
        }
    }
}
