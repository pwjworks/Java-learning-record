package site.pwjworks.lambda;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = new Love();
        love.love(2);
    }
}

interface ILove {
    void love(int a);
}

class Love implements ILove {

    @Override
    public void love(int a) {
        System.out.println("I love you-->" + a);
    }
}
