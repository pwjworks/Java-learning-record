package site.pwjworks.lambda;

public class TestLambda1 {
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 3. 具名内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();
        // 4. 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        // 5. lambda表达式
        like = () -> {
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
}

interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}