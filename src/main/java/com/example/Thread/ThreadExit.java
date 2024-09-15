package com.example.Thread;

public class ThreadExit {

    public static void main(String[] args) throws InterruptedException {
        //在主线程中对子线程进行终止（通过终止run方法来实现对子线程的终止） -> 通知方式
        T t = new T();
        t.start();

        Thread.sleep(5*1000);
        t.setLoot(false);
    }
}

class T extends Thread{
    private int sum = 0;
    boolean loot = true;
    @Override
    public void run() {
        while (loot){
            System.out.println("TTT正在运行"+ (++sum));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoot(boolean loot) {
        this.loot = loot;
    }
}