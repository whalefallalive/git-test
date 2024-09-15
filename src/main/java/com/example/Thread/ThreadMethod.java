package com.example.Thread;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("线程原本的名字="+Thread.currentThread().getName());//获取mian线程的名字
        Thread.currentThread().setName("ctwo");//修改mian线程的名字
        System.out.println("线程被修改名字了="+Thread.currentThread().getName());

        Method method = new Method();
        method.start();//启动子线程

        System.out.println(method.getName() + "线程的优先级=" + method.getPriority());
        method.setPriority(Thread.MAX_PRIORITY);//修改线程的优先级
        System.out.println(method.getName() + "线程的优先级=" + method.getPriority());

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        method.setName("gq");

        method.interrupt();//中断子线程的休眠



    }

}
class Method extends Thread{

    private boolean loop = true;
    @Override
    public void run() {

        while (loop) {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程的名字=" + Thread.currentThread().getName() + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "线程在休眠中。。。");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //当该线程执行到一个Interrupt方法被调用时，捕获到这个异常时，会中断休眠，让程序提前执行
                //InterruptedException 是捕获（catch）一个中断异常
                System.out.println("线程" + Thread.currentThread().getName() + "被 Interrupt(中断) 了。。。");
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
