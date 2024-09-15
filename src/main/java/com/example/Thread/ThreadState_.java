package com.example.Thread;

public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        State01 state01 = new State01();
        System.out.println(state01.getName() + "的状态是= " + state01.getState());
        state01.start();
        System.out.println(state01.getName() + "的状态是= " + state01.getState());

        while (Thread.State.TERMINATED != state01.getState()){
            Thread.sleep(1000);
            System.out.println(state01.getName() + "的状态是= " + state01.getState());
        }

        System.out.println(state01.getName() + "的状态是= " + state01.getState());
    }
}

class State01 extends Thread{
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "正在执行中  " + i);
            }
            break;
        }
    }
}