package site.pwjworks.lambda;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("I love you-->" + a);
        };
        love.love(2);
        // 简化1
        love = (a) -> {
            System.out.println("I love you-->" + a);
        };
        love.love(3);
        love = a -> {
            System.out.println("I love you-->" + a);
        };
        love.love(4);
    }
}

interface ILove {
    void love(int a);
}


