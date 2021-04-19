package site.pwjworks.state;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin test = new TestJoin();
        Thread thread = new Thread(test);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
