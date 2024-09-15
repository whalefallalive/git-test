package com.example.Thread;

public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前进程数量
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前进程数量为：" + cpuNums);
    }
}
