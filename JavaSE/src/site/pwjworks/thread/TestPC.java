package site.pwjworks.thread;

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            try {
                container.push(new Chicken(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了-->" + container.pop().id + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Chicken {
    public int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    public Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void push(Chicken chicken) throws InterruptedException {
        if (count == 10) {
            this.wait();
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() throws InterruptedException {
        while (count == 0) {
            this.wait();
        }
        count--;
        this.notifyAll();
        return chickens[count];
    }
}