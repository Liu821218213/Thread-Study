package com.kuang.Thread02_Method;

/**
 * @Author Orust
 * @Create 2021/3/15 15:04
 */


public class TestLambda2 {
    public static void main(String[] args) {
        class Love implements ILove {
            @Override
            public void love(int a) {
                System.out.println("i love you -->" + a);
            }
        }
//        ILove love = new Love();

        //Lambda表达式简化
        ILove love = (int a) -> {
            System.out.println("I Love1 " + a);
        };

        //简化1.去掉参数类型
        love = (a) -> {
            System.out.println("I Love2 " + a);
        };

        //简化2.参数括号
        love = a -> {
            System.out.println("I Love3 " + a);
            System.out.println("I Love33 " + a);
        };

        //简化3.花括号
        love = a -> System.out.println("I Love4 " + a);

        /*
        总结：
        1.Lambda表达式原本只有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块{}包裹
        2.前提是接口为函数式接口（只包含唯一一个抽象方法）
            函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
            函数式接口可以被隐式转换为 lambda 表达式。
        3.多个参数也可以去多参数类型，要去掉就都去掉，然后必须加上括号
        */

        love.love(521);
    }
}

interface ILove {
    void love(int a);
}

