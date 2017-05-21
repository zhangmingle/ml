package com.ml.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class FileTest {
	private static final String FileName = "file.txt";

    public static void main(String[] args) {
  /*      testWrite();
        testRead();*/
       // savePic(FileName);
        copyFile("D:\\testFile\\file.txt","D:\\testFile1\\");
        
    }

    /**
     * FileOutputStream 演示函数
     *
     * 运行结果：
     * 在源码所在目录生成文件"file.txt"，文件内容是“abcdefghijklmnopqrstuvwxyz0123456789”
     *
     * 加入，我们将 FileOutputStream fileOut2 = new FileOutputStream(file, true);
     *       修改为 FileOutputStream fileOut2 = new FileOutputStream(file, false);
     * 然后再执行程序，“file.txt”的内容变成"0123456789"。
     * 原因是：
     * (01) FileOutputStream fileOut2 = new FileOutputStream(file, true);
     *      它是以“追加模式”将内容写入文件的。即写入的内容，追加到原始的内容之后。
     * (02) FileOutputStream fileOut2 = new FileOutputStream(file, false);
     *      它是以“新建模式”将内容写入文件的。即删除文件原始的内容之后，再重新写入。
     */
    
    private static void savePic(String fileName) {
    	 
        OutputStream os = null;
        try {
          String path = "D:\\testFile\\";
          // 2、保存到临时文件
          // 1K的数据缓冲
          byte[] bs = new byte[1024];
          // 读取到的数据长度
          int len;
          // 输出的文件流保存到本地文件
     
          File tempFile = new File(path);
          if (!tempFile.exists()) {
            tempFile.mkdirs();
          }
          os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
          // 开始读取
          PrintStream out1 = new PrintStream(os);
          out1.print("123456789");
          out1.close();
          
        } catch (IOException e) {
          e.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          // 完毕，关闭所有链接
          try {
            os.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    

    
    public static void copyFile(String oldPath, String newPath) { 
        try { 
            int bytesum = 0; 
            int byteread = 0; 
            File oldfile = new File(oldPath); 
            if (oldfile.exists()) { //文件存在时 
                InputStream inStream = new FileInputStream(oldPath); //读入原文件 
                FileOutputStream fs = new FileOutputStream(newPath); 
                byte[] buffer = new byte[1444]; 
                int length; 
                while ( (byteread = inStream.read(buffer)) != -1) { 
                    bytesum += byteread; //字节数 文件大小 
                    fs.write(buffer, 0, byteread); 
                } 
                inStream.close(); 
            } 
        } 
        catch (Exception e) { 
            System.out.println("复制单个文件操作出错"); 
            e.printStackTrace(); 
        } 
    } 
    
    
    
    private static void testWrite() {
        try {
            // 创建文件“file.txt”对应File对象
            File file = new File(FileName);
            // 创建文件“file.txt”对应的FileOutputStream对象，默认是关闭“追加模式”
            FileOutputStream fileOut1 = new FileOutputStream(file);
            // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out1 = new PrintStream(fileOut1);
            // 向“文件中”写入26个字母
            out1.print("123456789");
            out1.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileInputStream 演示程序
     */
    private static void testRead() {
        try {
            // 方法1：新建FileInputStream对象
            // 新建文件“file.txt”对应File对象
            File file = new File(FileName);
            FileInputStream in1 = new FileInputStream(file);

            // 方法2：新建FileInputStream对象
            FileInputStream in2 = new FileInputStream(FileName);

            // 方法3：新建FileInputStream对象
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fdin = in2.getFD();
            // 根据“文件描述符”创建“FileInputStream”对象
            FileInputStream in3 = new FileInputStream(fdin);

            // 测试read()，从中读取一个字节
            char c1 = (char)in1.read();
            System.out.println("c1="+c1);

            // 测试skip(long byteCount)，跳过4个字节
            in1.skip(25);

            // 测试read(byte[] buffer, int byteOffset, int byteCount)
            byte[] buf = new byte[10];
            in1.read(buf, 0, buf.length);
            System.out.println("buf="+(new String(buf)));


            // 创建“FileInputStream”对象对应的BufferedInputStream
            BufferedInputStream bufIn = new BufferedInputStream(in3);
            // 读取一个字节
            char c2 = (char)bufIn.read();
            System.out.println("c2="+c2);

            in1.close();
            in2.close();
            in3.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
