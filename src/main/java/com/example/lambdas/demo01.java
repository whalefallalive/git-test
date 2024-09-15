package com.example.lambdas;

public class demo01 {
    public static void main(String[] args) {
        useEatable( ()->{
            System.out.println("=========");
        });
    }
    public static void useEatable(Eatable e){
        e.eat();
    }

    interface  Eatable{
        void eat();
    }

}

