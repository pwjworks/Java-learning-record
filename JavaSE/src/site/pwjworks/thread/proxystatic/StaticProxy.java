package site.pwjworks.proxystatic;

public class StaticProxy {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("i love you")).start();
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("happy");
    }
}

class WeddingCompany implements Marry {
    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    public void before() {
        System.out.println("结婚之前，布置现场");
    }

    public void after() {
        System.out.println("结婚之后，收尾款");
    }
}