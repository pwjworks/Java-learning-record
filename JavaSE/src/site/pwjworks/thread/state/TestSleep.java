package site.pwjworks.state;

public class TestSleep implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        try {
            System.out.println("sleeping");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (flag) {

            System.out.println("run...Thread" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestSleep TestSleep = new TestSleep();
        new Thread(TestSleep).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                TestSleep.stop();
                System.out.println("线程停止");
            }
        }
    }
}