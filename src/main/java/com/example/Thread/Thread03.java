package com.example.Thread;

public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();//启动第1个线程
        thread2.start();//启动第2个线程
    }

}

class T1 implements Runnable{
    int couts = 0;
    @Override
    public void run() {
        //每隔一秒，输出AAA，执行10次
        while (true){
            System.out.println("AAA " + (++couts) );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (couts == 10){break;}
        }
    }
}
class T2 implements Runnable{
    int couts = 0;
    @Override
    public void run() {
        //每隔一秒，输出BBB，执行5次
        while (true){
            System.out.println("BBB " + (++couts));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (couts == 5){break;}
        }
    }
}

