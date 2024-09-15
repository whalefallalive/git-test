package com.example.Thread;

public class Thread01 {
    public static void main(String[] args) {

        //创建Cat对象，可以当做线程使用(子线程Thread-0)
        Cat cat = new Cat();
        //cat.run();
        //直接run方法只是一个普通的方法，没有真正的启动一个线程，就是只有把这个方法执行完成后，才会执行后续的
        cat.start();//启动线程->最终会执行run方法
        /*     start()方法底层执行
           (1)
           public synchronized void start() {
                    start0();
           }
           (2)
           //start0() 是本地方法，是JVM调用的，底层是C/C++实现的
           //可以理解为start0()方法才是启动多线程的，而不是run()方法
            private native void start0();

         */

        //说明：主线程（main线程）启动时，不会影响子线程（Thread-0）
        //主线程会正常执行，子线程也会正常执行，不会阻塞主线程
        System.out.println("主线程继续执行 ，线程的名字=" + Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            System.out.println("主线程 i= " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//   线程的使用方法

//1、当一个类继承了Thread类，这个类就是一个线程
// （Thread类是实现了Runnable这个接口    Thread的Run方法是实现了接口的Runnable接口的Run方法）
//      继承Thread类的这个类，然后重写run方法，在这个run方法里面写上自己的需要执行的业务

//2、当一个类实现了Runnable接口，这个类就是一个线程



class Cat extends Thread{
    int sum = 0;
    @Override
    public void run() {  //重写run()方法
        while (true) {
            //每个一秒执行一次线程
            System.out.println("ccccc" + (++sum) + "线程的名字：" + Thread.currentThread().getName());
            //让线程休眠一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //让线程执行10次后结束
            if (sum == 80){
                break;
            }
        }
    }
}
