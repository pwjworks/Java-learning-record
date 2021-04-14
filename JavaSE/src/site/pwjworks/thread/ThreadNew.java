package site.pwjworks.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();
        FutureTask<Integer> future = new FutureTask<>(new MyThread3());
        new Thread(future).start();
        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

class MyThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 100;
    }
}
