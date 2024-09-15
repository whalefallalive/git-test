package com.example.ioStream;





import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }
    //方式一：new File(String pathname)//根据路径构建一个File对象
    @Test
    public void create01(){
        String pathname = "e:\\news2.txt";
        File file = new File(pathname);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式二：new File(File parent,,String child)		//根据父目录文件+子路径构建\
    @Test
    public void create02(){
        File file = new File("e:\\");
        String child = "news02.txt";
        File file1 = new File(file, child);
        try {
            file1.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //方式三：new File(String parent,String child)		//根据父目录+子路径构建
    @Test
    public void create03(){
        String parentPath = "e:\\";
        String childPath = "news03.txt";
        File file = new File(parentPath, childPath);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
