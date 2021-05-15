package AThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread{
    String url;
    String name;
    public TestThread2(String name, String url) {
        this.url = url;
        this.name = name;
    }
    public void run(){
        WebDownLoader downLoader = new WebDownLoader();
        downLoader.downloader(url,name);
        System.out.println("下载成功");
    }
    public static void main(String[] args) {
        TestThread2 thread = new TestThread2("2.jpg","https://uploadfiles.nowcoder.com/images/20200424/63_1587723086302_D6D9F76E4729A8F43A760B15BCD606F3");
        thread.run();
    }
}
class WebDownLoader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
